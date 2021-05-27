package com;

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

public class UstProductAppMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(UstProductAppMysqlApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
//				.paths(PathSelectors.ant("/product/*"))
				.apis(RequestHandlerSelectors.basePackage("com.ust.pms.controller")).build().apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo("Product App Info", "CRUD operations on product", "1.0", "license",
				new Contact("Tufail Ahmed", "http://www.tufailahmed.com", "tufailahmedkhan@gmail.com"), "API Licence",
				"http://www.tufailahmed.com", Collections.emptyList());

	}
}
