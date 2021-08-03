package com.api.apiback.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiback.model.Cidade;
import com.api.apiback.repository.interCidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private interCidadeRepository cidData;
	
	public Cidade cadastrar(Cidade cidade) {
		return cidData.save(cidade);
	}
	
	public Collection<Cidade> buscarTodos(){
		return cidData.findAll();
	}
	public Optional<Cidade> buscarPorId(Long codigo) {
		return cidData.findById(codigo); 
	}
	public Cidade alterar(Cidade cidade) {
		return cidData.save(cidade);
	}

}
