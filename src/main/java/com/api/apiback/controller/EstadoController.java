package com.api.apiback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.apiback.model.Estado;
import com.api.apiback.repository.interEstadoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/estado")
@Api(value="API REST Venda de Reciclagem")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoController {
	
	@Autowired
	private interEstadoRepository EstRepository;
	
	 EstadoController(interEstadoRepository InterEstadoRepository) {
	       this.EstRepository = InterEstadoRepository;
	   }
	 
	  //O código para listar todos os contatos está listado abaixo:
	 //Listando todos os contatos (GET /estado)
	 @GetMapping
	 @ApiOperation(value="Retorna todos os estados")
	 public List findAll(){
	    return EstRepository.findAll();
	 }
	 
	 //O código para listar apenas um contato buscando pelo seu ID está listado abaixo:
	 //Obtendo um estado especídifo pelo ID (GET /estado/{id})
	 @GetMapping(path = {"/{codigo}"})
	 @ApiOperation(value="Retorna um estado específico utilizando o id")
	 public ResponseEntity findById(@PathVariable long codigo){
	    return EstRepository.findById(codigo)
	            .map(record -> ResponseEntity.ok().body(record))
	            .orElse(ResponseEntity.notFound().build());
	 }
	 
	 //O código para criar um novo contato está listado abaixo:
	 //Criando um novo estado (POST /estado)
	 @PostMapping
	 @ApiOperation(value="Adiciona um estado")
	 public Estado create(@RequestBody Estado estado){
	    return EstRepository.save(estado);
	 }
	 
	 //O código para atualizar um contato existente está listado abaixo:
	 //Atualizando um estado (PUT /estado)
	 @PutMapping(value="/{codigo}")
	 @ApiOperation(value="Altera as informações de um estado pelo id")
	 public ResponseEntity update(@PathVariable("codigo") long codigo, @RequestBody Estado estado) {
		 
	    return EstRepository.findById(codigo)
	            .map(record -> {
	                record.setSigla(estado.getSigla());
	                record.setNome(estado.getNome());
	                Estado updated = EstRepository.save(record);
	                return ResponseEntity.ok().body(updated);
	            }).orElse(ResponseEntity.notFound().build());
	 }
	 //O código para remover um contato pelo ID está listado abaixo:
	 //Removendo um estado pelo ID (DELETE /estado/{id})
	 @DeleteMapping(path ={"/{codigo}"})
	 @ApiOperation(value="Deleta um estado utilizando o id")
	 public ResponseEntity<?> delete(@PathVariable long codigo) {
	    return EstRepository.findById(codigo)
	            .map(record -> {
	                EstRepository.deleteById(codigo);
	                return ResponseEntity.ok().build();
	            }).orElse(ResponseEntity.notFound().build());
	 }

}
