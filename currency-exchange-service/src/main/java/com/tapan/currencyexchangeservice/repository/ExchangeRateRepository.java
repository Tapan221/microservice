package com.tapan.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tapan.currencyexchangeservice.bean.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate,Long> {
	
	//findBy is common but we can add column names as shown below , this is the feature of JPA Repository
	ExchangeRate findByFromAndTo(String from, String to);

}
