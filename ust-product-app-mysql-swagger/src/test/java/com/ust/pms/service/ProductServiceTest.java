package com.ust.pms.service;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductServiceTest {

	ProductService productservice;
	@BeforeEach
	void setUp() throws Exception {
		productservice=new ProductService();
	}

	@AfterEach
	void tearDown() throws Exception {
		productservice=null;
	}

	@Test
	void testAddnumbers() {
		int actvalue=productservice.addnumbers(10, 20);
		assertEquals(30, actvalue);
	}
	@Test
	void testAddnumbers1() {
		int actvalue=productservice.addnumbers(100, 20);
		assertEquals(120, actvalue);
	}

}
