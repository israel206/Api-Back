package com.api.apiback.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.apiback.model.Material;
import com.api.apiback.repository.interMaterialRepository;

@Service
public class MaterialService {
	
	@Autowired
	private interMaterialRepository matData;
	
	public Material cadastrar(Material material) {
		return matData.save(material);
	}
	
	public Collection<Material> buscarTodos(){
		return matData.findAll();
	}
	public Optional<Material> buscarPorId(Long codigo) {
		return matData.findById(codigo); 
	}
	public Material alterar(Material material) {
		return matData.save(material);
	}


}
