package com.hexaware.CMS.serviceImpl;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexaware.CMS.entity.AuthUser;
import com.hexaware.CMS.repository.AuthUserRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {
	private AuthUserRepository userRepository;
	// Constructor DI
	@Autowired
	public CustomUserDetailsService(AuthUserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		AuthUser user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));
		Set<GrantedAuthority> authorities = user.getRoles().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
		return new org.springframework.security.core.userdetails.User(usernameOrEmail, user.getPassword(), authorities);
	}
}
