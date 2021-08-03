package com.api.apiback.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiback.model.Item;
import com.api.apiback.repository.interItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private interItemRepository ItemData;
	
	public Item cadastrar(Item item) {
		return ItemData.save(item);
	}
	
	public Collection<Item> buscarTodos(){
		return ItemData.findAll();
	}
	public Optional<Item> buscarPorId(Long codigo) {
		return ItemData.findById(codigo); 
	}
	public Item alterar(Item item) {
		return ItemData.save(item);
	}

}
