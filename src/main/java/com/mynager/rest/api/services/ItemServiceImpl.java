package com.mynager.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mynager.rest.api.config.UserSpringSecurity;
import com.mynager.rest.api.controller.exception.AuthorizationException;
import com.mynager.rest.api.model.Item;
import com.mynager.rest.api.model.User;
import com.mynager.rest.api.repository.ItemRepository;
import com.mynager.rest.api.repository.UserRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itRepository;
	
	@Autowired
	private UserRepository usRepository;

	@Override
	public void save(Item item) {
		item.setId(null);
		itRepository.save(item);
	}

	@Override
	public void update(Item item) {
		itRepository.save(item);
	}

	@Override
	public void delete(long id) {
		itRepository.deleteById(id);
	}

	@Override
	public List<Item> findAll() {
		UserSpringSecurity userCont = UserSpringSecurityServiceImpl.authenticated();
		if (userCont == null) {
			throw new AuthorizationException("Access Denied.");
		}
		User user = usRepository.findById(userCont.getId());
		return itRepository.findByUser(user);
	}

	@Override
	public List<Item> findByUser(User user) {
		return itRepository.findByUser(user);
	}
}
