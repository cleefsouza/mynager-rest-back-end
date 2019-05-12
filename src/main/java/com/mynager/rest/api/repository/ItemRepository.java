package com.mynager.rest.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mynager.rest.api.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	// retrieve item by id
	Item findById(long id);
	
	// list items by type
	List<Item> findByType(Long id);
	
	// list items by situation
	List<Item> findBySituation(Long id);
}
