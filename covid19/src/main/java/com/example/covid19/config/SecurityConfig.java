package com.example.covid19.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().
		authorizeRequests().
		antMatchers("/api/auth/**").
		permitAll().
		anyRequest().
		authenticated();
	}
	
	//This bean is used for Bcrypt password encoding 
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();		
	}
	
	//the class AuthenticationManagerBuilder manages the authentication is Spring
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) {
		
	}

}
