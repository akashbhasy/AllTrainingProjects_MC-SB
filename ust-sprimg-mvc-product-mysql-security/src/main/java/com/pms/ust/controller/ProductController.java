package com.pms.ust.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ust.pms.Model.Product;
import com.ust.pms.Model.UserRegistration;
import com.ust.pms.service.ProductService;



@Controller
public class ProductController {

	@Autowired
	ProductService productservice;

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
	
	@RequestMapping(value = "/login" ,method=RequestMethod.GET )
	public String login(Model model, String error, String logout) {
		if(error!=null) {
			model.addAttribute("errormsg","USERNAME or PASSWORD INCORRECT");
			
		}
		if(logout!=null) {
			model.addAttribute("msg","Sucessfully logout");
			
		}
		return "login";
	}
	
	@RequestMapping(value= "/registration", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("registration","user",new UserRegistration());
		
	}
	
	@Autowired
	JdbcUserDetailsManager jdbcuserdetailsmanager;
	@RequestMapping(value ="/registration",method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("user") UserRegistration userregisteration) {
		
		List<GrantedAuthority> authorities= new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		User user=new User(userregisteration.getUsername(), userregisteration.getPassword(),authorities);
		jdbcuserdetailsmanager.createUser(user);
		
		return new ModelAndView("login","message","You have been sucesfully registered");
		
		
		
	}
}
