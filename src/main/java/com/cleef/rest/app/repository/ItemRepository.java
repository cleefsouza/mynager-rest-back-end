package com.cleef.rest.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleef.rest.app.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	// retrieve item by id
	Item findById(long id);
	
	// list items by type
	List<Item> findByType(long id);
}
