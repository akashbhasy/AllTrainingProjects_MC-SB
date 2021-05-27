package com.ust.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.kafka.service.Kafkasender;

@RestController
@RequestMapping("/kafka")
public class Mycontroller {
	
	@Autowired
	Kafkasender kafkasender;
	@GetMapping("/sendmessage/{message}")
	public String sendmessage(@PathVariable("message") String messages ) {
		
		kafkasender.sendMessageUsingKafka(messages);
		return "message send successfully";
	}
	
	@GetMapping("/sendmessage")
	public String sendmessage2(@RequestParam("message") String messages ) {
		
		kafkasender.sendMessageUsingKafka(messages);
		return "message send successfully";
	}

}
