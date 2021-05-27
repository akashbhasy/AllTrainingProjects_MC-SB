package com.ust.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ust.kafka.model.KafkaSsgModel;
import com.ust.kafka.repository.KafkaRepository;



@Service
public class KafkaReciever {
	
	@Autowired
	KafkaRepository kafkaRepository;

	Logger logger=LoggerFactory.getLogger(KafkaReciever.class);
	@KafkaListener(topics = "UST100",groupId = "mt-topic-group-id")
	public void receiveMessage(String message) {
		
		
		
		logger.info("Messageeeeeeeee"+message);
		KafkaSsgModel model=new KafkaSsgModel();
		model.setMessage(message);
		//model.setMsg_id(1);
		kafkaRepository.save(model);
		
	}
	
}
