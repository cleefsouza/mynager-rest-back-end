package com.mynager.rest.api.services;

import java.util.List;

import com.mynager.rest.api.model.Item;
import com.mynager.rest.api.model.User;

public interface ItemService {

	// save item
	void save(Item item);

	// delete item by id
	void delete(long id);

	// save item
	void update(Item item);

	// find all
	List<Item> findAll();

	// find items by user
	List<Item> findByUser(User user);
	
	// find by id
	Item findById(long id);
}
