package com.mynager.rest.api.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.mynager.rest.api.controller.exception.NotFoundException;
import com.mynager.rest.api.model.User;
import com.mynager.rest.api.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository usRepository;

	@Override
	public User findByUsername(String username) {
		User user = usRepository.findByUsername(username);
		if (user == null) {
			throw new NotFoundException("Ops! User not found.");
		}
		return user;
	}

	@Override
	public User findById(long id) {
		User user = usRepository.findById(id);
		if (user == null) {
			throw new NotFoundException("Ops! User not found.");
		}
		return user;
	}

}
