package com.mynager.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mynager.rest.api.model.Type;
import com.mynager.rest.api.repository.TypeRepository;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeRepository tyRepository;

	@Override
	public List<Type> findAll() {
		return tyRepository.findAll();
	}

}
