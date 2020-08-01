package com.example.covid19.service_auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.covid19.model.User;
import com.example.covid19.repository_auth.AuthRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private AuthRepository authRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =authRepository.findByUserName(username).orElseThrow(()->new UsernameNotFoundException("No user name in DB"+username));
		return null;
	}

}
