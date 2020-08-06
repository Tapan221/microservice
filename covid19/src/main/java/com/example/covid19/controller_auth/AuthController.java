package com.example.covid19.controller_auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.covid19.model_auth.User;
import com.example.covid19.service_auth.AuthService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	private AuthService authService; 
	

	@PostMapping("/registerUser")
	public User registerUser(@RequestBody User user) throws Exception {
		
		//check user already present or not
		if(user.getEmail()!= null && user.getEmail()!="") {
			User userObj = authService.findByEmailId(user.getEmail());
			if(userObj!= null) {
				throw new Exception("user with mail "+userObj.getEmail()+ "already exist in DB");
			}
		}				
		return authService.saveUser(user);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) throws Exception {
		String email=user.getEmail();
		String password= user.getPassword();
		User userObject = null;
		if(email!= null && password!= null)
		 userObject = authService.findUserByMailIdAndPassword(email,password);	
		
		if(userObject == null) {
			throw new Exception("Bad Credential, these credentials does ot match the data in DB");
		}
		return userObject;
		
	}

}
