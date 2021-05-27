package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	Environment environment;

	@GetMapping("/")
	public String index() {
		return "product-App";
	}
	
	@GetMapping("/productBackend")
	public String productBackend() {
		
		String serverPort=environment.getProperty("local.server.port");
		System.out.println("##########Inside ProductController Backend################"+serverPort);
		
		return "Hello from productController localhost:"+serverPort;
	}
	
	
}
