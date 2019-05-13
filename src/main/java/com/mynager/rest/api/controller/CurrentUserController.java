package com.mynager.rest.api.controller;

import org.jboss.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mynager.rest.api.model.CurrentUser;

@ControllerAdvice
public class CurrentUserController {
	
	private static final Logger LOGGER = Logger.getLogger(CurrentUserController.class);
	
	@ModelAttribute("user_details")
	public CurrentUser getCurrentUserAdvice(Authentication authenticate) {
		LOGGER.debug("Accessing getCurrentUserAdvice");
		return (authenticate == null) ? null : (CurrentUser) authenticate.getPrincipal();
	}

}
