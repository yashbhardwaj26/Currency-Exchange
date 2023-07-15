package com.CurrencyExchange;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
	
	@GetMapping("/sample-api")
	public String getExampler() {
		
		
	RestTemplate rt = 	new RestTemplate();
		ResponseEntity<String> forEntity = rt.getForEntity("localHOst:8080/String", String.class);
		return forEntity.getBody();
	}

}
