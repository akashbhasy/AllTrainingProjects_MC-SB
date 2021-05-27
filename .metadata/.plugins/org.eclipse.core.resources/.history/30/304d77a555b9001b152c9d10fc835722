package com.ust.pms.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("product")
//@Slf4j
public class ProductController {
	Logger logger= LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productservice;

	// @RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {

		if (productservice.isproductExist(product.getProductId())) {
			logger.warn("Alredy exixt");
			return new ResponseEntity<String>("Product Allredy exist", HttpStatus.CONFLICT);
		} else {
			productservice.saveproduct(product);
			logger.info("********Product saved Sucessfullyt********");
			return new ResponseEntity<String>("Product saved Sucessfully", HttpStatus.CREATED);
		}

	}

	// @RequestMapping(method=RequestMethod.DELETE)
	@DeleteMapping(path = "{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") Integer productId) {
		if (productservice.isproductExist(productId)) {
			productservice.deleteProduct(productId);
			return new ResponseEntity<String>("Product Deleted Successfully", HttpStatus.OK);
		} else {

			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
	}

	// @RequestMapping(method = RequestMethod.PUT)
	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {

		if (productservice.isproductExist(product.getProductId())) {
			productservice.updateProduct(product);
			return new ResponseEntity<String>("Product updated sucessfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Product not found", HttpStatus.CONFLICT);
		}

	}

	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	public ResponseEntity<List<Product>> getProduct() {
		if (productservice.getproducts().isEmpty()) {
			// return ResponseEntity<List<Product>>(Product,HttpStatus.CONFLICT);
			return new ResponseEntity<List<Product>>(HttpStatus.OK);
		} else {
			//List product = (List) productservice.getproducts();
			return new ResponseEntity<List<Product>>((List<Product>) productservice.getproducts(),HttpStatus.OK) ;
		}

	}

	@GetMapping(path = "{productId}")
	public Product getsingleProduct(@PathVariable("productId") Integer productId) {

		System.out.println("ProductId=" + productId);

		return productservice.getproduct(productId);

	}

	@GetMapping(path = "/searchByproductName/{productname}")
	public List<Product> searchproductByname(@PathVariable("productname") String productname) {

		System.out.println("productname=" + productname);

		return productservice.searchProductName(productname);

	}
	
	@GetMapping(path = "/searchproductByrange/{lower}/{higher}")
	public List<Product> searchproductByrange(@PathVariable("lower") int lower,@PathVariable("higher") int higher) {

		//System.out.println("productname=" + productname);

		return productservice.searchProductByRange(lower, higher);

	}

}
