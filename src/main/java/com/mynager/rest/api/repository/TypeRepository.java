package com.mynager.rest.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mynager.rest.api.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long>{
	
	// find all types
	List<Type> findAll();
}