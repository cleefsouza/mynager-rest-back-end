package com.mynager.rest.api.config.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter{
	
	private JWTUtil jwtUtil;
	private UserDetailsService usDetailsService;
	
	// constructor
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserDetailsService usDetailsService) {
		super(authenticationManager);
		this.jwtUtil = jwtUtil;
		this.usDetailsService = usDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            UsernamePasswordAuthenticationToken auth = getAuthentication(header.substring(7));
            if (auth != null) {
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        
        response.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(request, response);
	}
	
	   private UsernamePasswordAuthenticationToken getAuthentication(String token) {
	        if (jwtUtil.validToken(token)) {
	            String email = jwtUtil.getEmail(token);
	            UserDetails user = usDetailsService.loadUserByUsername(email);
	            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
	        }
	        return null;
	    }
	
	

}
