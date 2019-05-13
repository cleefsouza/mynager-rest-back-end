package com.mynager.rest.api.model;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {
	
	private static final long serialVersionUID = 1L;

	private User user;
	
	public CurrentUser(User user) {
		super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user = user;
	}
	
	// getters

	public User getUser() {
		return user;
	}

	public long getId() {
		return user.getId();
	}
	
	public Role getRole() {
		return user.getRole();
	}
}
