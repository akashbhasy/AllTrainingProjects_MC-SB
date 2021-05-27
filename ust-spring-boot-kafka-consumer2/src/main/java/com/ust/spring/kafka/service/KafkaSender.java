package com.ust.spring.kafka.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import com.ust.spring.kafka.model.Customer;

@Service
public class KafkaSender {
	
	Logger logger=LoggerFactory.getLogger(KafkaSender.class);
	
	@Value("${kafka.topic.name}")
	private String topicname;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendData(Customer customer) {
		
		Map<String, Object> headers=new HashMap<String, Object>();
		headers.put(KafkaHeaders.TOPIC, topicname);
		kafkaTemplate.send(new GenericMessage<Customer>(customer, headers));
		logger.info("CustomerData:"+customer+"sent to "+topicname);
	}
}
