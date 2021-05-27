package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ust.pms.controller")
@ComponentScan("com.ust.pms.service")
public class UstProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UstProductAppApplication.class, args);
	}

}
