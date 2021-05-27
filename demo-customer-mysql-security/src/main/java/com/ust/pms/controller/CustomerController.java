package com.ust.pms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ust.pms.Model.Customer;
import com.ust.pms.Model.UserRegistration;
import com.ust.pms.service.CustomerService;

@Controller

public class CustomerController {

	@Autowired
	CustomerService customerservice;

	@RequestMapping("/index")
	public ModelAndView index() {
		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {

			username = ((UserDetails) principal).getUsername();

		}
		ModelAndView view = new ModelAndView();
		view.addObject("username", username);
		view.setViewName("index");
		return view;
	}

	@RequestMapping("/addcustomer")
	public ModelAndView addcustomer() {

		return new ModelAndView("addcustomer", "command", new Customer());
	}

//	@GetMapping
//	public List<Customer> getallCustomer() {
//
//		return customerservice.getAllCustomer();
//	}

	@RequestMapping("/savecustomer")
	public String saveCustomer(Customer customer) {
		System.out.println("haiiiiiiiiii"+customer);
		customerservice.saveCustomer(customer);
		return "ProductAddScusses";
	}

	@RequestMapping("/viewAllcustomers")
	public ModelAndView viewAllcustomers() {

		List<Customer> customer = customerservice.getAllCustomer();

		return new ModelAndView("viewAllcustomers", "customer", customer);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("errormsg", "USERNAME or PASSWORD INCORRECT");

		}
		if (logout != null) {
			model.addAttribute("msg", "Sucessfully logout");

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
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		User user=new User(userregisteration.getUsername(), userregisteration.getPassword(),authorities);
		jdbcuserdetailsmanager.createUser(user);
		
		return new ModelAndView("login","message","You have been sucesfully registered");
		
		
		
	}
}
