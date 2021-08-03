package com.api.apiback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.apiback.model.Cliente;

public interface interClienteRepository extends JpaRepository<Cliente, Long>{

}
