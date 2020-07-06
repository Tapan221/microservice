package com.example.vmwarenumbergenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vmwarenumbergenerator.model.Generator;

@Repository
public interface NumberRepo extends JpaRepository<Generator, Integer>{

}
