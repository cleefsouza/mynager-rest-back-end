package com.mynager.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mynager.rest.api.controller.exception.NotFoundException;
import com.mynager.rest.api.model.Item;
import com.mynager.rest.api.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itRepository;

	@Override
	public Item findById(long id) {
		Item item = itRepository.findById(id);
		if (item == null) {
			throw new NotFoundException("Ops! Item not found.");
		}
		return item;
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
	public void save(Item item) {
		itRepository.save(item);
	}

	@Override
	public List<Item> findAll() {
		return itRepository.findAll();
	}

	@Override
	public void delete(Item item) {
		itRepository.delete(item);
	}

	@Override
	public void update(Item item) {
		itRepository.save(item);
	}

}
