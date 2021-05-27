package com.ust.spring.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddress {
	
	private int addressId;
	private String city;
	private String state;
	private String pincode;

}
