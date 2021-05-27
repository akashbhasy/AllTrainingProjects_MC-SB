package com.ust.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("credentilas")
public class ConfigProps {

	private String username;
	private String password;
	private String attempt;
}
