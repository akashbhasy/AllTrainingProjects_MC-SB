package com.ust.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.Model.Product;
import com.ust.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productrepository;

	public List<Product> getproducts() {
		return (List<Product>) productrepository.findAll();

	}

	public Product getproduct(Integer productId) {
		Optional<Product> product = productrepository.findById(productId);
		return product.get();
	}

	public void saveproduct(Product product) {

		productrepository.save(product);
	}

	public void deleteProduct(Integer productid) {

		productrepository.deleteById(productid);
	}

	public void updateProduct(Product product) {

		productrepository.save(product);

	}

	public List<Product> searchProductName(String productname) {

		return productrepository.findByProductName(productname);
	}

	public boolean isproductExist(int productId) {
		return productrepository.existsById(productId);

	}

}
