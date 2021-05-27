package com.ust;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UstHandonDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(UstHandonDemo1Application.class, args);
	}
	
	
	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.paths(PathSelectors.ant("/**"))
				.apis(RequestHandlerSelectors.basePackage("com.ust.controller")).build().apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo("Customer Application", "CRUD operations on Customer", "1.0", "license",
				new Contact("Akash Bhasy", "http://www.akashbhasy.com", "akashbhasy@gmail.com"), "API Licence",
				"http://www.akashbhasy.com", Collections.emptyList());

	}

}
