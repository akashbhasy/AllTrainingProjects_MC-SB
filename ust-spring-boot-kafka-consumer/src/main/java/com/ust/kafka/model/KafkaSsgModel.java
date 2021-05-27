package com.ust.kafka.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "kafkamessage")
public class KafkaSsgModel {
	@Id
	private int msg_id;
	private String message;

	}

	
