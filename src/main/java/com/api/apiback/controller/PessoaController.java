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

import com.api.apiback.model.Pessoa;
import com.api.apiback.repository.interPessoaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/pessoa")
@Api(value="API REST Venda de Reciclagem")
@CrossOrigin(origins = "http://localhost:4200")
public class PessoaController {
	
	
	@Autowired
    private interPessoaRepository _pessoaRepository;

    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    @ApiOperation(value="Retorna todas as pessoas")
    public List<Pessoa> Get() {
        return _pessoaRepository.findAll();
    }
    //Segunda forma  de fazer o crud

    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
    @ApiOperation(value="Retorna uma pessoa específica informando o id")
    public ResponseEntity<Pessoa> GetById(@PathVariable(value = "codigo") long codigo)
    {
        Optional<Pessoa> pessoa = _pessoaRepository.findById(codigo);
        if(pessoa.isPresent())
            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/pessoa", method =  RequestMethod.POST)
    @ApiOperation(value="Adiciona uma pessoa")
    public Pessoa Post(@Valid @RequestBody Pessoa pessoa)
    {
        return _pessoaRepository.save(pessoa);
    }

    @RequestMapping(value = "/pessoa/{codigo}", method =  RequestMethod.PUT)
    @ApiOperation(value="Altera uma pessoa pelo id")
    public ResponseEntity<Pessoa> Put(@PathVariable(value = "codigo") long codigo, @Valid @RequestBody Pessoa newPessoa)
    {
        Optional<Pessoa> oldPessoa = _pessoaRepository.findById(codigo);
        if(oldPessoa.isPresent()){
            Pessoa pessoa = oldPessoa.get();
            pessoa.setNome(newPessoa.getNome());
            pessoa.setCpf(newPessoa.getCpf());
            pessoa.setRg(newPessoa.getRg());
            pessoa.setRua(newPessoa.getRua());
            pessoa.setNumero(newPessoa.getNumero());
            pessoa.setBairro(newPessoa.getBairro());
            pessoa.setCep(newPessoa.getCep());
            pessoa.setComplemento(newPessoa.getComplemento());
            pessoa.setTelefone(newPessoa.getTelefone());
            pessoa.setCelular(newPessoa.getCelular());
            pessoa.setEmail(newPessoa.getEmail());
            _pessoaRepository.save(pessoa);
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/pessoa/{codigo}", method = RequestMethod.DELETE)
    @ApiOperation(value="Deleta uma pessoa pelo id")
    public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") long codigo)
    {
        Optional<Pessoa> pessoa = _pessoaRepository.findById(codigo);
        if(pessoa.isPresent()){
            _pessoaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
