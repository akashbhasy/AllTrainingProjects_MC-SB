package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.ust.openid.YamlLoaderInitializer;

@SpringBootApplication
public class UstSpringOidcDiscoveryAppApplication {

	public static void main(String[] args) {
		SpringApplication application=new SpringApplication(UstSpringOidcDiscoveryAppApplication.class);
		ApplicationContextInitializer<ConfigurableApplicationContext> yamlInitializer=new YamlLoaderInitializer("discovery-application.yml");
		application.addInitializers(yamlInitializer);
		application.run(args);
		
	}

}
