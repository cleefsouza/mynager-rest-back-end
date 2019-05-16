package com.mynager.rest.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService usDetailsService;
	
	private static final String[] PUBLIC_MATCHERS = { "/items", "/items/{id}", "/items/type/{id}",
			"/items/situation/{id}", "/user", "user/{id}"};

	private static final String[] ADMIN_MATCHERS = { "/user","/user/**", "/items", "/items/**"};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();		
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/").permitAll()
			
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS).hasRole("USER")
			.antMatchers(HttpMethod.POST, "/items").hasRole("USER")
			.antMatchers(HttpMethod.PUT, "/items", "/user").hasRole("USER")
			.antMatchers(HttpMethod.DELETE, "/items", "/user").hasRole("USER")
			
			.antMatchers(HttpMethod.GET, ADMIN_MATCHERS).hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, ADMIN_MATCHERS).hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT, ADMIN_MATCHERS).hasRole("ADMIN")
			.antMatchers(HttpMethod.DELETE, ADMIN_MATCHERS).hasRole("ADMIN")
			.anyRequest().authenticated()
				.and()
			.formLogin().permitAll()
				.and()
			.logout().permitAll()
				.and()
			.rememberMe();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usDetailsService).passwordEncoder(passwordEncoder());
	}
}