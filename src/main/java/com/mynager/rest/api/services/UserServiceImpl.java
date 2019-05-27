package com.mynager.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mynager.rest.api.config.UserSpringSecurity;
import com.mynager.rest.api.controller.exception.AuthorizationException;
import com.mynager.rest.api.controller.exception.EmailAlreadyExistsException;
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
		UserSpringSecurity userCont = UserSpringSecurityServiceImpl.authenticated();
		if (userCont == null || !email.equals(userCont.getUsername())) {
			throw new AuthorizationException("Access Denied.");
		}
		
		User user = usRepository.findByEmail(email);
		if (user == null) {
			throw new NotFoundException("User not found.");
		}
		
		return user;
	}

	@Override
	public User findById(long id) {
		UserSpringSecurity userCont = UserSpringSecurityServiceImpl.authenticated();
		if (userCont == null || id != userCont.getId()) {
			throw new AuthorizationException("Access Denied.");
		}

		User user = usRepository.findById(id);
		if (user == null) {
			throw new NotFoundException("User not found.");
		}
		
		return user;
	}

	@Override
	public void save(User user) {
		user.setId(0L);
		User userEquals = usRepository.findByEmail(user.getEmail());
		if (userEquals != null) {
			throw new EmailAlreadyExistsException("Email already exists!");
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usRepository.save(user);
	}

	@Override
	public void update(User user) {
		UserSpringSecurity userCont = UserSpringSecurityServiceImpl.authenticated();
		if (userCont == null || user.getId() != userCont.getId()) {
			throw new AuthorizationException("Access Denied.");
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usRepository.save(user);
	}

	@Override
	public void delete(long id) {
		UserSpringSecurity userCont = UserSpringSecurityServiceImpl.authenticated();
		if (userCont == null || id != userCont.getId()) {
			throw new AuthorizationException("Access Denied.");
		}
		usRepository.deleteById(id);
	}

	@Override
	public List<User> findAll() {
		return usRepository.findAll();
	}
}
