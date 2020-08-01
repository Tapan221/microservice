package com.example.zrestswagger.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zrestswagger.model.Student;
import com.example.zrestswagger.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAllStudentDetails(){
		return studentService.getAllStudent();	
	}
	
	@GetMapping("/students/{roll}")
	public Optional<Student> getStudentDetails(@PathVariable int roll){		
		return studentService.getStudentDetailsBasedOnRoll(roll);
	}
	
	@PostMapping("/save")
	public Optional<Student> addStudentDetails(@RequestBody Student student) {
		return studentService.saveStudentDetails(student);
	}
	
	@DeleteMapping("/delete/{roll}")
	public void deleteStudent(@PathVariable int roll) {
		studentService.deleteStudent(roll);
	}
	

}
