package com.example.covid19.repository_auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.covid19.model.User;

@Repository
public interface AuthRepository extends JpaRepository<User, Long>{

	Optional<User> findByUserName(String username);



	

}
