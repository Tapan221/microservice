package com.tapan.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tapan.currencyexchangeservice.bean.ExchangeRate;
import com.tapan.currencyexchangeservice.repository.ExchangeRateRepository;

import ch.qos.logback.classic.Logger;

@RestController
public class CurrencyExchangeController {
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeRateRepository exchangeRaterepo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeRate getExchangeRate(@PathVariable String from , @PathVariable String to) {
		//hard coded
		//ExchangeRate exchangeRate= new ExchangeRate(1000L,from, to, BigDecimal.valueOf(70));
		
		//get data from DB 
		logger.info("getExchangeRate method called");
		ExchangeRate exchangeRate= exchangeRaterepo.findByFromAndTo(from, to);
		//we set property of port using Environment..		
		exchangeRate.setPort(Integer.valueOf(environment.getProperty("local.server.port")));				
		return exchangeRate;
	}
	
	

}
