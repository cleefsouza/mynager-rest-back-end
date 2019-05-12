package com.mynager.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mynager.rest.api.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long>{

}