package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableDiscoveryClient(autoRegister=false)
@EnableEurekaClient()
public class UstSpringCloudEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(UstSpringCloudEurekaClientApplication.class, args);
	}

}
