package com.mynager.rest.api.services;

import com.mynager.rest.api.model.User;

public interface UserService {

	// find user by username
	User findByUsername(String username);
	
	// find by id
	User findById(long id);
}
