package com.mynager.rest.api.services;

import java.util.List;

import com.mynager.rest.api.model.Item;

public interface ItemService {

	// retrieve item by id
	Item findById(long id);
	
	// update item
	void update(Item item);

	// list items by type
	List<Item> findByType(Long id);

	// list items by situation
	List<Item> findBySituation(Long id);

	// save item
	void save(Item item);

	// retrive all items
	List<Item> findAll();
	
	// delete item
	void delete(Item item);
}
