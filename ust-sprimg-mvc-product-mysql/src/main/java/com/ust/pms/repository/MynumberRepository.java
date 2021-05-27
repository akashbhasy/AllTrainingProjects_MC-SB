package com.ust.pms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ust.pms.Model.Numbers;


public interface MynumberRepository extends CrudRepository<Numbers, Integer> {

	
}
