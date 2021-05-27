package com.ust.pms.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@EnableWebSecurity
public class SecurityConfiguer extends WebSecurityConfigurerAdapter {

//	@Autowired
//	public  void configuerGlobal(AuthenticationManagerBuilder authmanagerbuilder) throws Exception {
//		authmanagerbuilder.inMemoryAuthentication()
//		.withUser("anu").password("anu123").authorities("ROLE_ADMIN").and()
//		.withUser("mohan").password("mohan123").authorities("ROLE_USER");
//		
//	}
	@Autowired
	DataSource datasource;

	@Autowired
	private void configAuthentication(AuthenticationManagerBuilder authmanagerbuilder) throws Exception {
		// TODO Auto-generated method stub
		authmanagerbuilder.jdbcAuthentication().dataSource(datasource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
				// .antMatchers("/").permitAll()
				.antMatchers("/registration").permitAll().antMatchers("/index").hasAnyRole("USER", "ADMIN")
				.antMatchers("/viewAllcustomers").hasAnyRole("USER", "ADMIN").antMatchers("/addcustomer")
				.hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
				.and().logout().permitAll();

		http.csrf().disable();
	}

	@Bean
	public JdbcUserDetailsManager jdbcuserdetaismanager() {
		JdbcUserDetailsManager jdbcuserdetailsmanager = new JdbcUserDetailsManager();
		jdbcuserdetailsmanager.setDataSource(datasource);
		return jdbcuserdetailsmanager;

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
