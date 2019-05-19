package com.mynager.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mynager.rest.api.model.Situation;
import com.mynager.rest.api.services.SituationService;

@RestController
@RequestMapping(value = "/situation", produces = "application/json")
public class SituationController {
	
	@Autowired
	private SituationService siService;
	
	/*
	 * methods
	 */
	
	@GetMapping()
	public List<Situation> findAll(){
		return siService.findAll();
	}
}