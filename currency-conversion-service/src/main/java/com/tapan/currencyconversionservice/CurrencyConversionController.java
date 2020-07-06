package com.tapan.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tapan.currencyconversionservice.bean.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	CurrencyConversionBean getCurrencyConversionValue(@PathVariable String from,@PathVariable String to, @PathVariable BigDecimal quantity ){
				
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		logger.info("Hello 12345678");
		//uriVariables are used to pass parameter to URI
		ResponseEntity<CurrencyConversionBean>  responseEntity =
		new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,uriVariables);
		
		CurrencyConversionBean response = responseEntity.getBody();
		
		return new CurrencyConversionBean(response.getId(),
				from,
				to,
				response.getconversionMultiple(),quantity,
				quantity.multiply(response.getconversionMultiple()),
				response.getPort());
	}
	
	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	CurrencyConversionBean getCurrencyConversionValueFeign(@PathVariable String from,@PathVariable String to, @PathVariable BigDecimal quantity ){
					
		CurrencyConversionBean response = currencyExchangeServiceProxy.getExchangeRate(from, to);
		
		return new CurrencyConversionBean(response.getId(),
				from,
				to,
				response.getconversionMultiple(),quantity,
				quantity.multiply(response.getconversionMultiple()),
				response.getPort());
	}

}
