package com.ust.spring.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.spring.kafka.model.Customer;
import com.ust.spring.kafka.service.KafkaSender;

@RestController
@RequestMapping("/sendCustomerData")
public class Mycontroller {
	
	@Autowired
	private KafkaSender kafkaSender;

	@PostMapping
	public String sendData(@RequestBody Customer customer) {
		
		kafkaSender.sendData(customer);
		
		return "Customer data send successfully";
		
	}
}
