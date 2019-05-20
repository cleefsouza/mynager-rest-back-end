package com.mynager.rest.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public Page<Item> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
		UserSpringSecurity userCont = UserSpringSecurityServiceImpl.authenticated();
		if (userCont == null) {
			throw new AuthorizationException("Access Denied.");
		}
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Sort.Direction.valueOf(direction), orderBy);
		User user = usRepository.findById(userCont.getId());
		return itRepository.findByUser(user, pageRequest);
	}

	@Override
	public Page<Item> findByUser(User user, Pageable page) {
		return itRepository.findByUser(user, page);
	}
}
