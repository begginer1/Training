package com.hexaware.demo.serviceImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexaware.demo.repository.UserRepository;


@Service
public class UserDetailServiceImpl implements UserDetailsService{

	private UserRepository userRepository;
	
	public UserDetailServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("user Not Found"));
	}

}
