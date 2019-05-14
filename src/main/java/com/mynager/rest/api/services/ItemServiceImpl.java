package com.mynager.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mynager.rest.api.model.Item;
import com.mynager.rest.api.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itRepository;
	
	@Override
	public Item findById(long id) {		
		return itRepository.findById(id);
	}

	@Override
	public List<Item> findByType(Long id) {		
		return itRepository.findByType(id);
	}

	@Override
	public List<Item> findBySituation(Long id) {
		return itRepository.findBySituation(id);
	}

	@Override
	public Item save(Item item) {
		return itRepository.save(item);
	}

	@Override
	public List<Item> findAll() {
		return itRepository.findAll();
	}

	@Override
	public void delete(Item item) {		
		itRepository.delete(item);
	}

}
