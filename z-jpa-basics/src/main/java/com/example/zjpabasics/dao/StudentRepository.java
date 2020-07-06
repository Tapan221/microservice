package com.example.zjpabasics.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zjpabasics.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
		
}
