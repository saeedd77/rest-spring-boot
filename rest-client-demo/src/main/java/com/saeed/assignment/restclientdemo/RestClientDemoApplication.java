package com.saeed.assignment.restclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientDemoApplication.class, args);
		Quotation.main(args);
		
	}

}
