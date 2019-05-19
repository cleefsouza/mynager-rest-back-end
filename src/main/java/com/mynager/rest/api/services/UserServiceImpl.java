package com.mynager.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mynager.rest.api.controller.exception.NotFoundException;
import com.mynager.rest.api.model.User;
import com.mynager.rest.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository usRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findByEmail(String email) {
		User user = usRepository.findByEmail(email);
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

	@Override
	public void save(User user) {
		user.setId(null);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usRepository.save(user);
	}
	
	@Override
	public void update(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usRepository.save(user);
	}

	@Override
	public void delete(long id) {
		usRepository.deleteById(id);
	}

	@Override
	public List<User> findAll() {
		return usRepository.findAll();
	}	
}
