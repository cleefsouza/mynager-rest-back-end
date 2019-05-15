package com.mynager.rest.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] PUBLIC_MATCHERS = {"/items", "/items/{id}", "/items/type/{id}",
			"/items/situation/{id}"};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS).hasRole("USER")
				.antMatchers(HttpMethod.POST, "/items").hasRole("USER")
				.antMatchers(HttpMethod.PUT, "/items").hasRole("USER")
				.antMatchers(HttpMethod.DELETE, "/items").hasRole("USER")
				.anyRequest().authenticated()
					.and()
				.formLogin().permitAll()
					.and()
				.logout().permitAll()
					.and()
				.rememberMe();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/style", "/style/**");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
