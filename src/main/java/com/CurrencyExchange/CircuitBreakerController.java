package com.CurrencyExchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	@Retry(name="default")
	public String getExampler() {
		
		logger.info("Sample api call received");
	RestTemplate rt = 	new RestTemplate();
		ResponseEntity<String> forEntity = rt.getForEntity("localHOst:8080/String", String.class);
		return forEntity.getBody();
	}

}
