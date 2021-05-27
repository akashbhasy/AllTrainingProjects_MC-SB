package com.ust.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.pms.Model.Numbers;
import com.ust.pms.Model.Product;
import com.ust.pms.repository.MynumberRepository;
import com.ust.pms.repository.ProductRepository;

@Service
public class MynumberService {

	@Autowired
	MynumberRepository mynumberRepository;

		public void saveproduct(Numbers number) {

			mynumberRepository.save(number);
	}

	
}
