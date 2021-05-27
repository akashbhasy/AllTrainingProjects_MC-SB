package com.ust.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Kafkasender {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	private final String topic="UST100";
	
	public void sendMessageUsingKafka(String message) {
		kafkaTemplate.send(topic, message);
		
	}

}
