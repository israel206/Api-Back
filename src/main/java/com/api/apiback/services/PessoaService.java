package com.api.apiback.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiback.model.Pessoa;
import com.api.apiback.repository.interPessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private interPessoaRepository pessData;
	
	public Pessoa cadastrar(Pessoa pessoa) {
		return pessData.save(pessoa);
	}
	
	public Collection<Pessoa> buscarTodos(){
		return pessData.findAll();
	}
	public Optional<Pessoa> buscarPorId(Long codigo) {
		return pessData.findById(codigo); 
	}
	public Pessoa alterar(Pessoa pessoa) {
		return pessData.save(pessoa);
	}


}
