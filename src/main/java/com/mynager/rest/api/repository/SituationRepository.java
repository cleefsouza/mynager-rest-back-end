package com.mynager.rest.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mynager.rest.api.model.Situation;

public interface SituationRepository extends JpaRepository<Situation, Long> {

	// find all situation
	List<Situation> findAll();
}
