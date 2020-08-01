package com.example.zrestswagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zrestswagger.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
