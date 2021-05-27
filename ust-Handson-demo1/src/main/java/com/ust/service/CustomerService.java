package com.ust.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.model.Customer;
import com.ust.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerrepository;

	// To Return all customer
	public List<Customer> getAllCustomer() {
		return (List<Customer>) customerrepository.findAll();
	}

	// To get a single Customer
	public Customer getOneCustomer(Integer customerId) {
		Optional<Customer> customer = customerrepository.findById(customerId);
		return customer.get(); 
	}

	// To save a new Customer
	public void saveCustomer(Customer customer) {
		customerrepository.save(customer);
	}

	// to delete a customer
	public void deleteConsumer(Integer customerId) {
		customerrepository.deleteById(customerId);
	}

	// to update the customer
	public void updateConsumer(Customer consumer) {
		customerrepository.save(consumer);
		
	}
	
	//Between Specific Range
	public List<Customer> searchInSpecificRange(Integer lowerprice,Integer higherprice){
		System.out.println("service"+lowerprice+" "+higherprice);
		return customerrepository.findByBillAmountBetween(lowerprice, higherprice);
	}
}
