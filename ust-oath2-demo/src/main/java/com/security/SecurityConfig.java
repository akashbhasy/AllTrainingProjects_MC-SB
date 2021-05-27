package com.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.requestMatchers()
			.antMatchers("/login","/oauth/authorize").and().authorizeRequests().anyRequest()
			.authenticated().and().formLogin().permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {	
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("akash").password(PasswordEncoder().encode("123456")).roles("USER");
		
	}
	
	@Bean
	public BCryptPasswordEncoder PasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
