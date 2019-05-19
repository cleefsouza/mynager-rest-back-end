package com.mynager.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mynager.rest.api.model.Type;
import com.mynager.rest.api.services.TypeService;

@RestController
@RequestMapping(value = "/type", produces = "application/json")
public class TypeController {
	
	@Autowired
	private TypeService tyService;
	
	/*
	 * methods
	 */
	
	@GetMapping()
	public List<Type> findAll(){
		return tyService.findAll();
	}

}
