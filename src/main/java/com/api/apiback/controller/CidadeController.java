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

import com.api.apiback.model.Cidade;
import com.api.apiback.repository.interCidadeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/cidade")
@Api(value="API REST Venda de Reciclagem")
@CrossOrigin(origins = "http://localhost:4200")
public class CidadeController {
	
	@Autowired
    private interCidadeRepository _cidadeRepository;

    @RequestMapping(value = "/cidade", method = RequestMethod.GET)
    @ApiOperation(value="Retorna todas as cidades")
    public List<Cidade> Get() {
        return _cidadeRepository.findAll();
    }
    //Segunda forma  de fazer o crud

    @RequestMapping(value = "/cidade/{id}", method = RequestMethod.GET)
    @ApiOperation(value="Retorna uma cidade específica informando o id")
    public ResponseEntity<Cidade> GetById(@PathVariable(value = "codigo") long codigo)
    {
        Optional<Cidade> cidade = _cidadeRepository.findById(codigo);
        if(cidade.isPresent())
            return new ResponseEntity<Cidade>(cidade.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cidade", method =  RequestMethod.POST)
    @ApiOperation(value="Adiciona uma cidade")
    public Cidade Post(@Valid @RequestBody Cidade cidade)
    {
        return _cidadeRepository.save(cidade);
    }

    @RequestMapping(value = "/cidade/{codigo}", method =  RequestMethod.PUT)
    @ApiOperation(value="Altera uma cidade pelo id")
    public ResponseEntity<Cidade> Put(@PathVariable(value = "codigo") long codigo, @Valid @RequestBody Cidade newCidade)
    {
        Optional<Cidade> oldCidade = _cidadeRepository.findById(codigo);
        if(oldCidade.isPresent()){
            Cidade cidade = oldCidade.get();
            cidade.setNome(newCidade.getNome());
            _cidadeRepository.save(cidade);
            return new ResponseEntity<Cidade>(cidade, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cidade/{codigo}", method = RequestMethod.DELETE)
    @ApiOperation(value="Deleta uma cidade pelo id")
    public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") long codigo)
    {
        Optional<Cidade> cidade = _cidadeRepository.findById(codigo);
        if(cidade.isPresent()){
            _cidadeRepository.delete(cidade.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
