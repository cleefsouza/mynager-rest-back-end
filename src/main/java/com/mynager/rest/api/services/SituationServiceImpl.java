package com.mynager.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mynager.rest.api.model.Situation;
import com.mynager.rest.api.repository.SituationRepository;

@Service
public class SituationServiceImpl  implements SituationService {

	@Autowired
	private SituationRepository siRepository;

	@Override
	public List<Situation> findAll() {
		return siRepository.findAll();
	}
}