package com.hexaware.CMS.service;

import com.hexaware.CMS.dto.JWTAuthResponse;
import com.hexaware.CMS.dto.LoginDto;
import com.hexaware.CMS.dto.RegisterDto;

public interface AuthService {
	JWTAuthResponse login(LoginDto dto);
	String register(RegisterDto dto);
}
