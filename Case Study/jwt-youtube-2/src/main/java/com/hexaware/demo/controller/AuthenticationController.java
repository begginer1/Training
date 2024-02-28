package com.hexaware.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.demo.entity.User;
import com.hexaware.demo.service.AuthenticationResponse;
import com.hexaware.demo.service.AuthenticationService;

@RestController

public class AuthenticationController {

	private final AuthenticationService authService;
	public AuthenticationController(AuthenticationService authService) {
	this.authService = authService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody User request) {
	return ResponseEntity.ok(authService.register(request));
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody User request) {
	return ResponseEntity.ok(authService.authenticate(request));
}
}
