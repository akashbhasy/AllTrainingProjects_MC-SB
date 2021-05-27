package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.security.AuthenticationRequest;
import com.ust.security.AuthenticationResponse;
import com.ust.security.JwtUtil;
import com.ust.security.MyUserDetails;

@RestController
public class MyRestController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetails myuserddetails;
	
	@Autowired
	JwtUtil jwtutil;
	
	@GetMapping("/ust")
	public String ustwelcome() {
		return "welcome to UST TVM";
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
