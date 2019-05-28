package com.mynager.rest.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mynager.rest.api.model.Item;
import com.mynager.rest.api.model.User;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	// find items by user
	@Transactional(readOnly = true)
	List<Item> findByUser(User user);

}
