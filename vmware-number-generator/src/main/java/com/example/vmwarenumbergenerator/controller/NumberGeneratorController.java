package com.example.vmwarenumbergenerator.controller;

import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vmwarenumbergenerator.model.Generator;
import com.example.vmwarenumbergenerator.model.ResponseObject;
import com.example.vmwarenumbergenerator.model.StreamData;
import com.example.vmwarenumbergenerator.service.NumberService;


@RestController
@RequestMapping("/api")
public class NumberGeneratorController {
	@Autowired
	private NumberService numberService;
	
	@PostMapping("/generate")
	public ResponseEntity<ResponseObject> saveNumberGenerator(@RequestBody Generator generator) {
		Map<String, Integer> map =  numberService.saveData(generator);
		ResponseObject obj = new ResponseObject();	
		obj.setTask(map.get("task"));
		return new ResponseEntity<ResponseObject>(obj,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/tasks/{uid}")
	public ResponseEntity<StreamData> getNumberList(@PathVariable int uid, @RequestParam("action") String action) {
		StreamData obj = new StreamData();
		obj.setResult(numberService.readDataBasedOnUid(uid));
		if(action.equalsIgnoreCase("get_numlist"))
		return new ResponseEntity<StreamData>(obj,HttpStatus.OK);
		else
			obj.setResult("No such Mapping exist");
		return new ResponseEntity<StreamData>(obj,HttpStatus.NOT_IMPLEMENTED);
		 		
	}

}
