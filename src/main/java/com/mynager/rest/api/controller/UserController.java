package com.mynager.rest.api.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mynager.rest.api.model.User;
import com.mynager.rest.api.services.UserService;

@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

	@Autowired
	private UserService usService;

	/*
	 * methods
	 */
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable long id) {
		return usService.findById(id);
	}

	@GetMapping("/email")
	public User getUserByEmail(@RequestParam(value = "value") String email) {
		return usService.findByEmail(email);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping("/block_user/{id}")
	public void blockUser(@PathVariable long id) {
		usService.blockUser(id);
	}

	/*
	 * crud
	 */

	@PostMapping()
	public void save(@Valid @RequestBody User user) {
		usService.save(user);
	}

	@PutMapping("/{id}")
	public void update(@Valid @RequestBody User user, @PathVariable("id") long id) {
		user.setId(id);
		usService.update(user);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") long id) {
		usService.delete(id);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/all")
	public List<User> findAll() {
		return usService.findAll();
	}
}
