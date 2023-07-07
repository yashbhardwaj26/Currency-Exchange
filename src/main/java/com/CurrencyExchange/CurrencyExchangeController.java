package com.CurrencyExchange;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@GetMapping("/currencyexhange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		String port = environment.getProperty("local.server.port");
		
		CurrencyExchange currencyExchange = new CurrencyExchange(1L,from,to,BigDecimal.valueOf(65));
		currencyExchange.setEnvironment(port);
		return currencyExchange;

	}

}
