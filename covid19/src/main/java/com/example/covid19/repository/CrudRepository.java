package com.example.covid19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.covid19.model.Contributer;


@Repository
public interface CrudRepository extends JpaRepository<Contributer, Integer> {

}
