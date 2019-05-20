package com.mynager.rest.api.config.jwt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mynager.rest.api.model.User;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authManager;
	private JWTUtil jwtUtil;

	// constructor
	public JWTAuthenticationFilter(AuthenticationManager authManager, JWTUtil jwtUtil) {
		super();
		this.authManager = authManager;
		this.jwtUtil = jwtUtil;
	}

	@Override // try authentication spring security
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {
			User userCreds = new ObjectMapper().readValue(request.getInputStream(), User.class);

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
					userCreds.getEmail(), userCreds.getPassword(), new ArrayList<>());

			Authentication auth = authManager.authenticate(authToken);
			return auth;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override // successful authentication
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		String email = ((UserDetails) authResult.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(email);

		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
	}

}
