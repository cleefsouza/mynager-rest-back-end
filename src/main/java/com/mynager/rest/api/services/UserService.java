package com.mynager.rest.api.services;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.mynager.rest.api.model.User;

public interface UserService {

	// find user by email
	User findByEmail(String email);

	// find by id
	User findById(long id);

	// save user
	void save(User user);

	// delete user by id
	void delete(long id);

	// find all user
	List<User> findAll();

	// update user
	void update(User user);
	
	// block user
	@Transactional
	@Modifying
	void blockUser(long id);
}
