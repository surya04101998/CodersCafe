package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.service.QuoteGenerator;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		System.out.println(QuoteGenerator.getQuote());
		SpringApplication.run(ApiApplication.class, args);
	}

}
