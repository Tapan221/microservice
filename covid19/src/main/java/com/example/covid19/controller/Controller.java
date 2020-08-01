package com.example.covid19.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.covid19.model.Contributer;
import com.example.covid19.model.Donation;
import com.example.covid19.service.CurdService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/apis")
public class Controller {
	
	@Autowired
	private CurdService service;
	
	//Contributer api calls
	@PostMapping("/saveContributer") 
	public Contributer saveDetails(@RequestBody Contributer contributer) {		
		return service.saveContributerDetails(contributer);	
	}
	
	@GetMapping("/getAllContributer")
	public List<Contributer> getAllContributers() {
		return service.getAllContributerDetails();		
	}
	
	//Donation Api calls
	@PostMapping("/saveDonation")
	public Donation saveDonationDetails(@RequestBody Donation donation) {
		return service.saveDonationDetails(donation);		
	}
	
	@GetMapping("/getAllDonations")
	public List<Donation> getAllDonationDetails(){
		return service.getAllDonationDetails();
		
	}
	

}
