package com.CurrencyExchange;

import java.math.BigDecimal;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		String port = environment.getProperty("local.server.port");
		
		CurrencyExchange currencyExchange = repo.findByFromAndTo(from, to);
		
		if(currencyExchange ==null) {
			
			throw new RuntimeException("Unable to return daata for from"+ from + "and to" + to);
		}
		
		//CurrencyExchange currencyExchange = new CurrencyExchange(1L,from,to,BigDecimal.valueOf(65));
		currencyExchange.setEnvironment(port);
		return currencyExchange;

	}

}
