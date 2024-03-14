package com.hexaware.CMS.service;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.CMS.dto.AuthUserDto;
import com.hexaware.CMS.dto.JWTAuthResponse;
import com.hexaware.CMS.dto.LoginDto;
import com.hexaware.CMS.dto.RegisterDto;
import com.hexaware.CMS.entity.AuthUser;
import com.hexaware.CMS.entity.Role;
import com.hexaware.CMS.exception.BadRequestException;
import com.hexaware.CMS.repository.AuthUserRepository;
import com.hexaware.CMS.repository.RoleRepository;
import com.hexaware.CMS.security.JwtTokenProvider;

import lombok.extern.slf4j.Slf4j;
 

 
 
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
	private AuthenticationManager authenticationManager;
	private AuthUserRepository userRepo;
	private RoleRepository roleRepo;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	public AuthServiceImpl(AuthenticationManager authenticationManager, 
			AuthUserRepository userRepo, RoleRepository roleRepo,PasswordEncoder passwordEncoder,
			JwtTokenProvider jwtTokenProvider) {
		this.authenticationManager = authenticationManager;
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}
	@Override
	public JWTAuthResponse login(LoginDto dto) {
		System.out.println(("object received"+dto));
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getUserName(), dto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenProvider.generateToken(authentication);
		System.out.println("Token generated : "+token);
		AuthUser user = userRepo.findByUsername(dto.getUserName()).get();
		System.out.println("user object found in repo "+user);
		AuthUserDto userDto = new AuthUserDto();
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setUsername(user.getUsername());
		String role = "ROLE_USER";
		Set<Role> roleUser = user.getRoles();
		
//		for(Role roleTemp:roleUser)
//		{
//			if(roleTemp.getName().equalsIgnoreCase("ROLE_STATION_HEAD"))
//				role = "ROLE_STATION_HEAD";
//			else if(roleTemp.getName().equalsIgnoreCase("ROLE_OFFICER"))
//				role = "ROLE_OFFICER";
//		}
		if(user.getRoles().contains(new Role("ROLE_OFFICER"))) {
			role = "ROLE_OFFICER";
		}
		else if(user.getRoles().contains(new Role("ROLE_STATION_HEAD"))) {
		role = "ROLE_STATION_HEAD";
		}
		userDto.setRole(role);
		return new JWTAuthResponse(token,userDto);
	}
	@Override
	public String register(RegisterDto dto) {
		Set<Role> roles=new HashSet<>();
		Role role;
		if(userRepo.existsByUsername(dto.getUsername()))
			throw new BadRequestException(HttpStatus.BAD_REQUEST, "Username already exist");
		if(userRepo.existsByEmail(dto.getEmail()))
			throw new BadRequestException(HttpStatus.BAD_REQUEST, "Email already exist");
		AuthUser user = new AuthUser();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setUsername(dto.getUsername());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		
		
		if(dto.getRoles().contains(new Role("ROLE_OFFICER"))) {
			role = roleRepo.findByName("ROLE_OFFICER").get();
		}
		else if(dto.getRoles().contains(new Role("ROLE_STATION_HEAD"))) {
		role = roleRepo.findByName("ROLE_STATION_HEAD").get();
		}
		else {
		role = roleRepo.findByName("ROLE_USER").get();
		}
		roles.add(role);
		user.setRoles(roles);
		userRepo.save(user);
		return "Register Successfull!..";
	}
}
