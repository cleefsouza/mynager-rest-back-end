package com.cleef.rest.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleef.rest.app.model.Situation;

public interface SituationRepository extends JpaRepository<Situation, Long>{

}
