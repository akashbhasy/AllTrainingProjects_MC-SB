package com;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class HelloImpl {

	@Autowired
	MyBackEndService mybackendservice;
	@Autowired
	RestTemplate restTemplate;
	
	

	@HystrixCommand(fallbackMethod = "myFallbackforData")
	public String getData() {
		return mybackendservice.getData();
	}
	@HystrixCommand(fallbackMethod = "myFallbackforgetAccounts")
	public ResponseEntity<String> getAccounts() {

		URI uri = URI.create("http://localhost:9099/demo");
		return restTemplate.getForEntity(uri, String.class);

	}
	
	public String myFallbackforData() {
		return "Interservice not available";
	}
	public ResponseEntity<String> myFallbackforgetAccounts() {
		return new ResponseEntity<String>("External service down",HttpStatus.OK);
	}
}
