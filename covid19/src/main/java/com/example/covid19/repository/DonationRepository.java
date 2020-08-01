package com.example.covid19.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.covid19.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Integer>{

}
