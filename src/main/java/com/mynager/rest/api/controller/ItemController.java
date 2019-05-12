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
import com.mynager.rest.api.repository.ItemRepository;

@RestController
@RequestMapping(value = "/items", produces = "application/json")
public class ItemController {

	@Autowired
	private ItemRepository itRepository;

	/*
	 * methods
	 */

	@GetMapping("/{id}")
	public Item getItemById(@PathVariable("id") long id) {
		return itRepository.findById(id);
	}
	
	@GetMapping("/type/{id}")
	public List<Item> getItemsByType(@PathVariable("id") Long id) {
		return itRepository.findByType(id);
	}
	
	@GetMapping("/situation/{id}")
	public List<Item> getItemsBySituation(@PathVariable("id") Long id) {
		return itRepository.findBySituation(id);
	}
	

	/*
	 * crud
	 */

	@GetMapping()
	public List<Item> getAllItems() {
		return itRepository.findAll();
	}

	@PostMapping("/create")
	public Item createItem(@Valid @RequestBody Item item) {
		return itRepository.save(item);
	}

	@PutMapping("/update")
	public Item updateItem(@Valid @RequestBody Item item) {
		return itRepository.save(item);
	}

	@DeleteMapping("/delete")
	public void deleteItem(@RequestBody Item item) {
		itRepository.delete(item);
	}
}
