package com.mynager.rest.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mynager.rest.api.config.jwt.JWTAuthenticationFilter;
import com.mynager.rest.api.config.jwt.JWTAuthorizationFilter;
import com.mynager.rest.api.config.jwt.JWTUtil;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService usDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;

	private static final String[] MATCHERS_GET = {"/item", "/user", "/type", "/situation", "/user/email/{value}"};
	
	private static final String[] MATCHERS_PUT_DELETE = {"/item/{id}", "/user/{id}"};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();

		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/").permitAll()
			.antMatchers(HttpMethod.GET, MATCHERS_GET).hasAnyRole("USER", "ADMIN")		
			.antMatchers(HttpMethod.POST, "/auth/refresh_token", "/item", "/user").hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.PUT, MATCHERS_PUT_DELETE).hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.DELETE, MATCHERS_PUT_DELETE).hasAnyRole("USER", "ADMIN")
			.anyRequest().authenticated();

		// register authentication filter 
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		// register authorization filter
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, usDetailsService));
		// session stateless
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration);
		return source;
	}

}