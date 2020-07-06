package com.example.zjpabasics.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zjpabasics.model.Student;
import com.example.zjpabasics.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students/{id}")
	public Optional<Student> getStudentDetailsById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
	
	@PostMapping("/saveStudentDetails")
	public ResponseEntity<Student> saveStudentDetails(@RequestBody Student student) {
		Optional<Student> studObject =  studentService.saveStudentDetails(student);			
		Student obj = new Student();
		obj.setName(student.getName());		
		return new ResponseEntity<Student>(obj,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent(){
		return studentService.getAllStudentDetails();
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
	}

}
