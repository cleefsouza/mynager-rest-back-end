package com.mynager.rest.api.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mynager.rest.api.model.Item;

public interface ItemService {

	// retrieve item by id
	Item findById(long id);

	// list items by type
	List<Item> findByType(Long id);

	// list items by situation
	List<Item> findBySituation(Long id);

	// save item
	void save(Item item);

	// retrive all items
	List<Item> findAll();

	// delete item by id
	void delete(long id);

	// save item
	void update(Item item);

	// items per page
	Page<Item> findPage(Integer page, Integer linePerPage, String direction, String orderBy);
}
