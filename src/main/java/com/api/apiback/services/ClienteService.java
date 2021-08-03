package com.api.apiback.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.apiback.model.Cliente;
import com.api.apiback.repository.interClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private interClienteRepository clientData;
	
	public Cliente cadastrar(Cliente cliente) {
		return clientData.save(cliente);
	}
	
	public Collection<Cliente> buscarTodos(){
		return clientData.findAll();
	}
	public Optional<Cliente> buscarPorId(Long codigo) {
		return clientData.findById(codigo); 
	}
	public Cliente alterar(Cliente cliente) {
		return clientData.save(cliente);
	}


}
