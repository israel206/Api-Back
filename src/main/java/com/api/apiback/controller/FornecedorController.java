package com.api.apiback.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.api.apiback.model.Fornecedor;
import com.api.apiback.repository.interFornecedorRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/fornecedor")
@Api(value="API REST Venda de Reciclagem")
@CrossOrigin(origins = "http://localhost:4200")
public class FornecedorController {
	
	@Autowired
    private interFornecedorRepository _fornecedorRepository;

    @RequestMapping(value = "/fornecedor", method = RequestMethod.GET)
    @ApiOperation(value="Retorna todas as pessoa")
    public List<Fornecedor> Get() {
        return _fornecedorRepository.findAll();
    }
    //Segunda forma  de fazer o crud

    @RequestMapping(value = "/fornecedor/{id}", method = RequestMethod.GET)
    @ApiOperation(value="Retorna uma fornecedor específica informando o id")
    public ResponseEntity<Fornecedor> GetById(@PathVariable(value = "codigo") long codigo)
    {
        Optional<Fornecedor> fornecedor = _fornecedorRepository.findById(codigo);
        if(fornecedor.isPresent())
            return new ResponseEntity<Fornecedor>(fornecedor.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/fornecedor", method =  RequestMethod.POST)
    @ApiOperation(value="Adiciona uma fornecedor")
    public Fornecedor Post(@Valid @RequestBody Fornecedor fornecedor)
    {
        return _fornecedorRepository.save(fornecedor);
    }

    @RequestMapping(value = "/fornecedor/{codigo}", method =  RequestMethod.PUT)
    @ApiOperation(value="Altera uma fornecedor pelo id")
    public ResponseEntity<Fornecedor> Put(@PathVariable(value = "codigo") long codigo, @Valid @RequestBody Fornecedor newFornecedor)
    {
        Optional<Fornecedor> oldFornecedor = _fornecedorRepository.findById(codigo);
        if(oldFornecedor.isPresent()){
            Fornecedor fornecedor = oldFornecedor.get();
            fornecedor.setDescricao(newFornecedor.getDescricao());
            _fornecedorRepository.save(fornecedor);
            return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/fornecedor/{codigo}", method = RequestMethod.DELETE)
    @ApiOperation(value="Deleta uma fornecedor pelo id")
    public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") long codigo)
    {
        Optional<Fornecedor> fornecedor = _fornecedorRepository.findById(codigo);
        if(fornecedor.isPresent()){
            _fornecedorRepository.delete(fornecedor.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
