package com.mynager.rest.api.services;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mynager.rest.api.controller.exception.NotFoundException;
import com.mynager.rest.api.model.User;
import com.mynager.rest.api.repository.RoleRepository;
import com.mynager.rest.api.repository.UserRepository;

/*
 * 	OBS: commented temporarily to test the front
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository usRepository;

	@Autowired
	private RoleRepository roRepository;

	/*@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	*/

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

    @Override
    public void save(User user) {
        // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roRepository.findAll()));
        usRepository.save(user);
    }
    
    public void delete(User user) {
    	usRepository.delete(user);
    }

	@Override
	public List<User> findAll() {		
		return usRepository.findAll();
	}
	
    @Override
    public void update(User user) {
        save(user);
    }
}
