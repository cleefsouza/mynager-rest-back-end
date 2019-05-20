package com.mynager.rest.api.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.mynager.rest.api.config.UserSpringSecurity;

public class UserSpringSecurityServiceImpl {
	// return user logged in
	public static UserSpringSecurity authenticated() {
		try {
			return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}

	}
}
