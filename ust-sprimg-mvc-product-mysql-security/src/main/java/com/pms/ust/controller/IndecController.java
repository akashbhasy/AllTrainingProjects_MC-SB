package com.pms.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ust.pms.Model.Numbers;
import com.ust.pms.Model.Product;
import com.ust.pms.service.MynumberService;
import com.ust.pms.service.ProductService;

@Controller
public class IndecController {

	@Autowired
	MynumberService mynumberservice;
	@RequestMapping("/index")
	public ModelAndView index() {
		String username=null;
		//ModelAndView view= new ModelAndView();
		//view.addObject("Name","AKASH");
		//view.setViewName("index");
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) {
			
			username=((UserDetails) principal).getUsername();
			
		}
		ModelAndView view= new ModelAndView();
		view.addObject("username",username);
		view.setViewName("index");
		return view;
	}
	
	@RequestMapping("/addtwonumbers")
	public String kapoor() {
		return"addtwonumbers";
	}
	
	
	
	@RequestMapping("/addnumbers")
	public ModelAndView addnumbers(Numbers nub) {
		int sum=nub.getFirstnumber()+nub.getSecondNumber()+nub.getThirdNumber()+nub.getFourthNumber()+nub.getFifthNumber();
		System.out.println("sum="+sum);
		nub.setResult(sum);
		mynumberservice.saveproduct(nub);
//		ModelAndView view= new ModelAndView();
//		view.addObject("Result",sum);
//		view.setViewName("resultsum");
		return  new ModelAndView("resultsum", "Result", sum);
	}
	
}
