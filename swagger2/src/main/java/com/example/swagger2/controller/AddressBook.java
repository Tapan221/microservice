package com.example.swagger2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger2.model.Contact;

@RestController
@RequestMapping("/api")
public class AddressBook {
	
	Map<Integer, Contact> contact = new HashMap<>();
	
	@GetMapping("/{id}")
	public Contact getContact(@PathVariable int id) {
		return contact.get(id);
	}
	
	@GetMapping("/")
	public List<Contact> getAllContacts(){
		return new ArrayList<Contact>(contact.values());
	}
	
	@PostMapping("/")
	public void addContact(@RequestBody Contact contactObj) {
		contact.put(contactObj.getId(),contactObj);
	}
	
	@GetMapping("/error")
	public String noMappingCase(){
		return "No Data Available";
	}

}
