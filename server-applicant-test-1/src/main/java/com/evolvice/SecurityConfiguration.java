/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright 2018 Evolvice and/or its affiliates.
 * All rights reserved.
 * Evolvice GmbH is a German software service provider with development hubs in Eastern Europe (Ukraine). The company services the information technology requirements of companies ranging from Fortune 500/DAX 30 to SMEs and startups, counting well-known companies such as Robert Bosch GmbH, Porsche AG, WTS tax consulting AG, etc as its clients..
 * CLASS NAME SecurityConfiguration.java
 * @author: Walaa Yousif <A HREF="mailto:[eng.walaa2011"gmail.com]">[Walaa Yousif]</A>
 * @version Revision: 1.1.1.1
 * @package com.evolvice
 * @see [SecurityConfiguration]
 */

package com.evolvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Walaa Yousif
 */

@PropertySource(value = { "classpath:application.properties" })
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment environment;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// In-Memory Option uncomment if required to do in memory authentication
		auth.inMemoryAuthentication().withUser(environment.getRequiredProperty("adminuser"))
				.password(environment.getRequiredProperty("adminpass")).roles("Car_Access", "Root_Access");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/car/**").hasRole("Car_Access").antMatchers("/**")
				.hasRole("Root-Access").and().csrf().disable();
	}

	@Bean(name = "securityPasswordEncoder")
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}

}
