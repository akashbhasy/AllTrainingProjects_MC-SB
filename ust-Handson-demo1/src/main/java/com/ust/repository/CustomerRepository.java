package com.ust.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ust.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer,Integer> {

	public List<Customer> findByBillAmountBetween(Integer lowerprice,Integer higherprice);
}
