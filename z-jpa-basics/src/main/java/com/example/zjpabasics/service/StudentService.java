package com.example.zjpabasics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.zjpabasics.dao.StudentRepository;
import com.example.zjpabasics.model.Student;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studRepository;
	
	public List<Student> getAllStudentDetails(){
		return studRepository.findAll();
	}
	
	public Optional<Student> getStudentById(int id){
		return studRepository.findById(id);
	}
	public Optional<Student> saveStudentDetails(Student student) {
		studRepository.save(student);
		return studRepository.findById(student.getId());
		
	}	
	public void deleteStudent(int id) {
		studRepository.deleteById(id);
	}

}
