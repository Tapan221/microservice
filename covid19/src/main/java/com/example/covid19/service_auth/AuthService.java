package com.example.covid19.service_auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.covid19.model.User;
import com.example.covid19.repository_auth.AuthRepository;

@Service
public class AuthService { 
	 
	@Autowired
	private AuthRepository authRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void signup(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		authRepository.save(user);
	}
	
}
