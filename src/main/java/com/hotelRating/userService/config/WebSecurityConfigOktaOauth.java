package com.hotelRating.userService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //not a web flux, this is default web security
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigOktaOauth {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests()
			.anyRequest()
			.authenticated()
			.and()
			.oauth2ResourceServer()
			.jwt();
		
		return httpSecurity.build();
	}
}
