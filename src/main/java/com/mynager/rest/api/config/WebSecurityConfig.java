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

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService usDetailsService;
	
	private static final String[] GENERAL_MATCHERS = {"/items", "/items/{id}", "/items/type/{id}",
			"/items/situation/{id}", "/user", "user/{id}"};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/").permitAll()
			
			.antMatchers(HttpMethod.GET, GENERAL_MATCHERS).hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.POST, "/items").hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.PUT, "/items", "/user").hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.DELETE, "/items", "/user").hasAnyRole("USER", "ADMIN")
			
			.antMatchers(HttpMethod.POST, "/user").hasRole("ADMIN")
			.anyRequest().authenticated()
				.and()
			.formLogin().permitAll()
				.and()
			.logout().permitAll()
				.and()
			.rememberMe();
	}

	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
}