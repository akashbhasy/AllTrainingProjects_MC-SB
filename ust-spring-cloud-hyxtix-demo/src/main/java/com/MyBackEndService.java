package com;

import org.springframework.stereotype.Component;

@Component
public class MyBackEndService {

	public String getData() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "Hi akash Message from back end";
	}
}
