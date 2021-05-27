package com.ust.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@GetMapping("/oidcpricipal")
	private OidcUser getoiduserprincipal(@AuthenticationPrincipal OidcUser pricipals) {
		// TODO Auto-generated method stub
		return pricipals;

	}
}
