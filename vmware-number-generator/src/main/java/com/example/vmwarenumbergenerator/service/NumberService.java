package com.example.vmwarenumbergenerator.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vmwarenumbergenerator.model.Generator;
import com.example.vmwarenumbergenerator.repository.NumberRepo;

@Service
public class NumberService {
	
	Map<String, Integer> map = new HashMap<>();
	File file = new File(System.getProperty("java.io.tmpdir"));
	String fileName = null;
	String filePath = null;
	String data= null;
	String result = null;
	
	
	@Autowired
	private NumberRepo numberRepo;
	
	
	public Map<String, Integer> saveData(Generator generator) {
		numberRepo.save(generator);
		map.put("task", generator.getId());
		fileName= generator.getId()+"_output.txt";
		filePath = file.getAbsolutePath()+"\\"+fileName;
				
	    try {
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
	    	int counter = generator.getGoal();
	    	while(counter >=0) {
	    		writer.write(counter+",");
	    		counter = counter-generator.getStep();
	    	}			
			 writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   		
		return map;
		
	}
	
	public String  readDataBasedOnUid(int uid) {
		fileName= uid+"_output.txt";
		filePath = file.getAbsolutePath()+"\\"+fileName;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			try {
				data = reader.readLine();
				result = data.substring(0, data.length()-1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@SuppressWarnings("finally")
	public String  getStatus(int uid) {
		fileName= uid+"_output.txt";
		filePath = file.getAbsolutePath()+"\\"+fileName;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			try {
				data = reader.readLine();
				result = data.substring(0, data.length()-1);
				result="SUCCESS";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="ERROR";
		}finally {
			return result;
		}
		
	}

}
