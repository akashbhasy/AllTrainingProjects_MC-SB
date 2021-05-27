package com.ust.pms.repository;

import org.springframework.data.repository.CrudRepository;

import com.ust.pms.Model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
