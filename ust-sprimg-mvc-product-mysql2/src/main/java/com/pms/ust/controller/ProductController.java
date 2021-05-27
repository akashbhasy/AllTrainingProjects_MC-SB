package com.pms.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ust.pms.Model.Product;
import com.ust.pms.service.ProductService;
import com.ust.security.AuthenticationRequest;
import com.ust.security.AuthenticationResponse;
import com.ust.security.JwtUtil;
import com.ust.security.MyUserDetails;



@Controller
public class ProductController {

	@Autowired
	ProductService productservice;
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetails myuserddetails;
	
	@Autowired
	JwtUtil jwtutil;

	@RequestMapping("/addproduct")
	public ModelAndView addProduct() {

		return new ModelAndView("addproduct", "command", new Product());
	}

	@RequestMapping("/saveproduct")
	public String saveProduct(Product product) {
		productservice.saveproduct(product);
		return "ProductAddScusses";
	}

	@RequestMapping("/searchProductById")
	public ModelAndView searchProductbyId() {
		return new ModelAndView("searchProductById", "command", new Product());
	}

	@RequestMapping("/searchbyId")
	public ModelAndView searchbyId(Product product) {

		int pid = product.getProductId();

		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("searchProductById");

		if (productservice.isproductExist(pid)) {
			Product productDetails = productservice.getproduct(pid);
			modelview.addObject("command", productDetails);
		} else {
			modelview.addObject("command", new Product());
			modelview.addObject("msg", "product with this productid:" + pid + " not available");
		}
		return modelview;
	}

	@RequestMapping("/deleteByID")
	public ModelAndView deleteByID(Product product) {

		int pid = product.getProductId();

		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("searchProductById");
		modelview.addObject("command", new Product());
		if (productservice.isproductExist(pid)) {
			productservice.deleteProduct(pid);
			modelview.addObject("msg", "product with this productid:" + pid + " deleted Sucessfully");
		} else {

			modelview.addObject("msg", "product with this productid:" + pid + " not available");
		}
		return modelview;
	}

	@RequestMapping("/viewAllProducts")
	public ModelAndView viewAllProducts() {
		
		List<Product> products=productservice.getproducts();

		return new ModelAndView("viewAllProducts","Products",products);
	}
	
	@RequestMapping(value="/authenticate" , method = RequestMethod.POST)
	public ResponseEntity<?> createAuthentionToken(@RequestBody AuthenticationRequest authreq) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authreq.getUsername(), authreq.getPassword()));
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("Incorrect username and password");
		}
		
		
		final UserDetails userdetails=myuserddetails.loadUserByUsername(authreq.getUsername());
		final String jwt= jwtutil.generateToken(userdetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}

}
