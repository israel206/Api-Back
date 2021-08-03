package com.api.apiback.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.apiback.model.Usuario;
import com.api.apiback.repository.interUsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private interUsuarioRepository usuaData;
	
	public Usuario cadastrar(Usuario usuario) {
		return usuaData.save(usuario);
	}
	
	public Collection<Usuario> buscarTodos(){
		return usuaData.findAll();
	}
	public Optional<Usuario> buscarPorId(Long codigo) {
		return usuaData.findById(codigo); 
	}
	public Usuario alterar(Usuario usuario) {
		return usuaData.save(usuario);
	}


}
