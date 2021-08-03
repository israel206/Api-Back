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


import com.api.apiback.model.Material;
import com.api.apiback.repository.interMaterialRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/material")
@Api(value="API REST Venda de Reciclagem")
@CrossOrigin(origins = "http://localhost:4200")
public class MaterialController {
	
	
	@Autowired
    private interMaterialRepository _materialRepository;

    @RequestMapping(value = "/material", method = RequestMethod.GET)
    @ApiOperation(value="Retorna todas as cidades")
    public List<Material> Get() {
        return _materialRepository.findAll();
    }
    //Segunda forma  de fazer o crud

    @RequestMapping(value = "/material/{id}", method = RequestMethod.GET)
    @ApiOperation(value="Retorna uma material específica informando o id")
    public ResponseEntity<Material> GetById(@PathVariable(value = "codigo") long codigo)
    {
        Optional<Material> material = _materialRepository.findById(codigo);
        if(material.isPresent())
            return new ResponseEntity<Material>(material.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/material", method =  RequestMethod.POST)
    @ApiOperation(value="Adiciona uma material")
    public Material Post(@Valid @RequestBody Material material)
    {
        return _materialRepository.save(material);
    }

    @RequestMapping(value = "/material/{codigo}", method =  RequestMethod.PUT)
    @ApiOperation(value="Altera uma material pelo id")
    public ResponseEntity<Material> Put(@PathVariable(value = "codigo") long codigo, @Valid @RequestBody Material newMaterial)
    {
        Optional<Material> oldMaterial = _materialRepository.findById(codigo);
        if(oldMaterial.isPresent()){
            Material material = oldMaterial.get();
            material.setDescricao(newMaterial.getDescricao());
            material.setQuantidade(newMaterial.getQuantidade());
            material.setPreco(newMaterial.getPreco());
            _materialRepository.save(material);
            return new ResponseEntity<Material>(material, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cidade/{codigo}", method = RequestMethod.DELETE)
    @ApiOperation(value="Deleta uma cidade pelo id")
    public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") long codigo)
    {
        Optional<Material> material = _materialRepository.findById(codigo);
        if(material.isPresent()){
            _materialRepository.delete(material.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
