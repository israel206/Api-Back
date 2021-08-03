package com.api.apiback.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiback.model.Fornecedor;
import com.api.apiback.repository.interFornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private interFornecedorRepository fornData;
	
	public Fornecedor cadastrar(Fornecedor fornecedor) {
		return fornData.save(fornecedor);
	}
	
	public Collection<Fornecedor> buscarTodos(){
		return fornData.findAll();
	}
	public Optional<Fornecedor> buscarPorId(Long codigo) {
		return fornData.findById(codigo); 
	}
	public Fornecedor alterar(Fornecedor fornecedor) {
		return fornData.save(fornecedor);
	}


}
