package com.ust.pms.controller;

import static org.assertj.core.api.Assertions.allOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.GreaterThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ust.pms.Model.Product;
import com.ust.pms.repository.ProductRepository;
import com.ust.pms.service.ProductService;

public class ProductControllerTest extends AbstractTest {

	@Autowired
	ProductRepository productrepository;

	@Autowired
	ProductService productservice;

	String uri = "/product";

	@Before
	@Override
	public void setUp() {
		// TODO Auto-generated method stub
		super.setUp();
	}

	@Test
	public void testGetProduct() throws Exception {

		MvcResult mvcResult = mokmvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		Product product[] = super.mapfromJson(content, Product[].class);

		assertTrue(product.length > 0);

	}

	@Test
	public void testSaveProduct() throws Exception {
		int productId = 120;
		Product product = new Product(productId, "iph0ne", 15, 7999);
		String inputJson = super.mapToJson(product);

		MvcResult mvcResult = mokmvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product saved Sucessfully");
		mokmvc.perform(MockMvcRequestBuilders.delete(uri + "/" + productId)).andReturn();

	}

//
//	@Test
//public	void testDeleteProduct() {
//		productservice.deleteProduct(12);
//		 Optional<Product> product = productrepository.findById(12); 
//		 assertNull(product.get().getProductId());
//		
//	}
//
	@Test
	public void testUpdateProduct() throws Exception {
		Product product = new Product(4, "iph0ne", 15, 1500);
		String inputJson = super.mapToJson(product);
		MvcResult mvcResult = mokmvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product updated sucessfully");

	}

//
//	
//
//	@Test
//	void testGetsingleProduct() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testSearchproductByname() throws Exception {
		boolean result = true;
		String productNameToSearch = "iph0ne";

		String productSearchUri = "/product/searchByproductName/" + productNameToSearch;

		MvcResult mvcResult = mokmvc
				.perform(MockMvcRequestBuilders.get(productSearchUri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		if (status == 200) {
			String content = mvcResult.getResponse().getContentAsString();
			Product productList[] = super.mapfromJson(content, Product[].class);
			for (Product p : productList) {
				if (p.getProductName().equals(productNameToSearch)) {

				} else {
					result = false;
					break;
				}
			}
			assertTrue(result);

		} else {
			fail("URI is not correct");
		}
	}

	@Test
	public void testsearchproductRange() throws Exception {
		String flag="novalue";
		int lowerrange = 1000;
		int higher=10000;

		String productSearchUri = "/product/searchproductByrange/" +lowerrange+"/"+higher;

		MvcResult mvcResult = mokmvc
				.perform(MockMvcRequestBuilders.get(productSearchUri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	if(status==200) {
		String content = mvcResult.getResponse().getContentAsString();
		Product productList[] = super.mapfromJson(content, Product[].class);
		for (Product p : productList) {
			if(p.getPrice()>lowerrange && p.getPrice()<higher) {
				flag="value";
			}
			else {
				flag="novalue";
			}
		}
		assertEquals("value", flag);
	}else {
		fail("URI is not correct");
	}

	}

}
