package com.mynager.rest.api.services;

import java.util.List;
import com.mynager.rest.api.model.User;

public interface UserService {

	// find user by username
	User findByUsername(String username);
	
	// find by id
	User findById(long id);
	
	// save user
	void save(User user);
	
	// delete user
	void delete(User user);
	
	// retrive all user
	List<User> findAll();
	
	// update user
	void update(User user);
}
