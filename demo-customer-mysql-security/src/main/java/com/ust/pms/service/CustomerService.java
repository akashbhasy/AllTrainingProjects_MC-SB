package com.ust.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.pms.Model.Customer;
import com.ust.pms.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerrepository;

	// To Return all customer
	public List<Customer> getAllCustomer() {
		return (List<Customer>) customerrepository.findAll();
	}

	// To save a new Customer
	public void saveCustomer(Customer customer) {
		customerrepository.save(customer);
	}

}
