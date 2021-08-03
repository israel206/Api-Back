package com.api.apiback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.apiback.model.Pessoa;

public interface interPessoaRepository extends JpaRepository<Pessoa, Long> {

}
