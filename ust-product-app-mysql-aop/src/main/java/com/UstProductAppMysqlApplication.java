package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//@EnableEurekaClient()
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class UstProductAppMysqlApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(UstProductAppMysqlApplication.class, args);
	}

}
