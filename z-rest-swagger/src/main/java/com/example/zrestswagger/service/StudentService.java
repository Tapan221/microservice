package com.example.zrestswagger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zrestswagger.model.Student;
import com.example.zrestswagger.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	
	public Optional<Student> saveStudentDetails(Student student) {
		studentRepository.save(student);
		return studentRepository.findById(student.getRoll());
	}
	
	public Optional<Student> getStudentDetailsBasedOnRoll(int roll) {
		return studentRepository.findById(roll);
	}
	
	
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	
	public void deleteStudent(int roll) {
		studentRepository.deleteById(roll);
	}
	
	

}
