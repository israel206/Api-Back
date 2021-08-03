package com.api.apiback.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiback.model.Estado;
import com.api.apiback.repository.interEstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private interEstadoRepository estData;
	
	public Estado cadastrar(Estado estado) {
		return estData.save(estado);
	}
	
	public Collection<Estado> buscarTodos(){
		return estData.findAll();
	}
	public Optional<Estado> buscarPorId(Long codigo) {
		return estData.findById(codigo); 
	}
	public Estado alterar(Estado estado) {
		return estData.save(estado);
	}
}
