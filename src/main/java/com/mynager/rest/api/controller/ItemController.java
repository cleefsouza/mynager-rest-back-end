package com.mynager.rest.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mynager.rest.api.model.Item;
import com.mynager.rest.api.services.ItemService;

@RestController
@RequestMapping(value = "/items", produces = "application/json")
public class ItemController {
	
	@Autowired
	private ItemService itService;

	/*
	 * methods
	 */

	@GetMapping("/{id}")
	public Item getItemById(@PathVariable("id") long id) {
		return itService.findById(id);
	}
	
	@GetMapping("/type/{id}")
	public List<Item> getItemsByType(@PathVariable("id") Long id) {
		return itService.findByType(id);
	}
	
	@GetMapping("/situation/{id}")
	public List<Item> getItemsBySituation(@PathVariable("id") Long id) {
		return itService.findBySituation(id);
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	

	/*
	 * crud
	 */

	@GetMapping()
	public List<Item> getAllItems() {
		return itService.findAll();
	}

	@PostMapping("/new")
	public Item createItem(@Valid @RequestBody Item item) {
		return itService.save(item);
	}

	@PutMapping("/upd")
	public Item updateItem(@Valid @RequestBody Item item) {
		return itService.save(item);
	}

	@DeleteMapping("/del")
	public void deleteItem(@RequestBody Item item) {
		itService.delete(item);
	}
}
