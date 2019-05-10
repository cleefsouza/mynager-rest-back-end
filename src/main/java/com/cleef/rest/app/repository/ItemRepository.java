package com.cleef.rest.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleef.rest.app.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
