package com;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Endpoint(id = "our-product-endpoint")
@Component
public class ProductEndpoints {

	@ReadOperation
	public ResponseEntity<String> getmessage(){
		return new ResponseEntity<String>("Hello Akash",HttpStatus.OK);
	}
	@WriteOperation
	public String postmessage(String spouse) {
		return "your spouse name:"+spouse;
	}
}
