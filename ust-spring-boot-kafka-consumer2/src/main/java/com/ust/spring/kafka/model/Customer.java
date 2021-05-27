package com.ust.spring.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private int customerId;
	private String customerName;
	private CustomerAddress customerAddress;
	private int billAmount;
}
