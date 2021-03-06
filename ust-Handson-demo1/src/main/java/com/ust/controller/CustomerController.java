package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.model.Customer;

import com.ust.service.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerservice;

	@ApiOperation(value = "Get list of Customers in the System ", response = Iterable.class, tags = "ToGetallCustomer")
	@GetMapping
	public List<Customer> getallCustomer() {

		return customerservice.getAllCustomer();
	}

	@ApiOperation(value = "Get a single Customers in the System ", response = Customer.class, tags = "ToGetSingleCustomer")
	@GetMapping(path = "{customerId}")
	public Customer getSingleCustomer(@PathVariable("customerId") Integer customerId) {
		return customerservice.getOneCustomer(customerId);
	}

	@ApiOperation(value = "Save Customers in the System ", response = Iterable.class, tags = "ToSaveCustomer")
	@PostMapping
	public String saveCustomer(@RequestBody Customer customer) {

		customerservice.saveCustomer(customer);

		return "Saved Customer Details";
	}

	@ApiOperation(value = "Delete a Customers in the System ", response = Iterable.class, tags = "ToDeleteCustomer")
	@DeleteMapping(path = "{custid}")
	public String deleteCustomer(@PathVariable("custid") Integer custid) {
		customerservice.deleteConsumer(custid);
		return "deleted";
	}
	
	@ApiOperation(value = "Update a  Customers in the System ", response = Iterable.class, tags = "ToUpDateCOnsumer")
	@PutMapping
	public String upDateCOnsumer(@RequestBody Customer customer) {
		customerservice.updateConsumer(customer);
		return "update";
	}
	
	@ApiOperation(value = "Search Customers based price in the System ", response = Iterable.class, tags = "ToSearchInSpecificRange")
	@GetMapping(path = "/searchRange/{lowerprice}/{higherprice}")
	public List<Customer> searchInSpecificRange(@PathVariable("lowerprice") Integer lowerprice,
			@PathVariable("higherprice") Integer higherprice) {

		System.out.println("contoller" + lowerprice + " " + higherprice);
		return customerservice.searchInSpecificRange(lowerprice, higherprice);

	}
}
