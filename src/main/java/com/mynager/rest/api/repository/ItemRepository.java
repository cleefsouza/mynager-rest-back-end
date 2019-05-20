package com.mynager.rest.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mynager.rest.api.model.Item;
import com.mynager.rest.api.model.User;

public interface ItemRepository extends JpaRepository<Item, Long> {

	// find items by user
	@Transactional(readOnly = true)
	Page<Item> findByUser(User user, Pageable page);
}
