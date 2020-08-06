package com.example.covid19.service_auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.covid19.model_auth.User;
import com.example.covid19.repository_auth.AuthRepository;

@Service
public class AuthService { 
	 
	@Autowired
	private AuthRepository authRepository;
	
	public User saveUser(User user) {
		return authRepository.save(user);
	}
	
	public User findByEmailId(String email) {
		return authRepository.findByEmail(email);
	}
	
	public User findUserByMailIdAndPassword(String email, String password) {	
		return authRepository.findByEmailAndPassword(email,password);		
	}
	
}
