package com.mynager.rest.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mynager.rest.api.model.Item;
import com.mynager.rest.api.model.User;

public interface ItemService {

	// save item
	void save(Item item);

	// delete item by id
	void delete(long id);

	// save item
	void update(Item item);

	// items per page
	Page<Item> findPage(Integer page, Integer linePerPage, String direction, String orderBy);
	
	// find items by user
	Page<Item> findByUser(User user, Pageable page);
}
