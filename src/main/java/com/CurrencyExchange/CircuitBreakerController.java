package com.CurrencyExchange;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
	
	@GetMapping("/sample-api")
	public String getExampler() {
		
		return "this is example";
	}

}
