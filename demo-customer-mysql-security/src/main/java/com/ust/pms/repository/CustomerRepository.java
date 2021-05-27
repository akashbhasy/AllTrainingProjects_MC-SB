package com.ust.pms.repository;

import org.springframework.data.repository.CrudRepository;

import com.ust.pms.Model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
