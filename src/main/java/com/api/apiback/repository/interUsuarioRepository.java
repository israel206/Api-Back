package com.api.apiback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.apiback.model.Usuario;

public interface interUsuarioRepository extends JpaRepository<Usuario, Long>{

}
