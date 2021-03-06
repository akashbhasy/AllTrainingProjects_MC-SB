package com.ust.pms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ust.pms.Model.Product;
import com.ust.pms.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService productservice;

	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public String saveProduct(@RequestBody Product product) {
		
		productservice.saveproduct(product);
		return "saving the product";
	}
	
	//@RequestMapping(method=RequestMethod.DELETE)
	@DeleteMapping(path = "{productId}")
	public String deleteProduct(@PathVariable("productId") Integer productId) {
		productservice.deleteProduct(productId);
		return "delete the product";
	}
	
	//@RequestMapping(method = RequestMethod.PUT)
		@PutMapping
		public String updateProduct(@RequestBody Product product) {
			productservice.updateProduct(product);
			return "Updating the product";
		}
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public List<Product> getProduct() {
		return  productservice.getproducts();
	}
	
	@GetMapping(path = "{productId}")
	public Product getsingleProduct(@PathVariable("productId") Integer productId) {
		
		System.out.println("ProductId="+productId);
		
		return productservice.getproduct(productId);
		
	}
	
	@GetMapping(path = "/searchByproductName/{productname}")
	public List<Product> searchproductByname(@PathVariable("productname") String productname) {
		
		System.out.println("productname="+productname);
		
		return productservice.searchProductName(productname);
		
	}
	
	
	
	
}
