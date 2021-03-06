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
@RequestMapping(value = "/item", produces = "application/json")
public class ItemController {

	@Autowired
	private ItemService itService;

	/*
	 * crud
	 */
	
	@GetMapping("/{id}")
	public Item getItemById(@PathVariable long id) {
		return itService.findById(id);
	}
	
	@GetMapping()
	public List<Item> findAll(){
		return itService.findAll();
	}
	

	@PostMapping()
	public void save(@Valid @RequestBody Item item) {
		itService.save(item);
	}

	@PutMapping("/{id}")
	public void update(@Valid @RequestBody Item item, @PathVariable("id") long id) {
		item.setId(id);
		itService.update(item);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") long id) {
		itService.delete(id);
	}
}
