package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.UserProfiles;

@RestController
public class MyRestController {

	@RequestMapping("/ust/userdetails")
	public ResponseEntity<UserProfiles> getuserprofile(){
		User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserProfiles userprofile=new UserProfiles();
		userprofile.setName(user.getUsername());
		userprofile.setEmail("akashbhasy@gmail.com");
		return ResponseEntity.ok(userprofile);
		
	}
}
