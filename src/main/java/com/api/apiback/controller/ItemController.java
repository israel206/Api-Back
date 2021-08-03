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

import com.api.apiback.model.Item;
import com.api.apiback.repository.interItemRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/item")
@Api(value="API REST Venda de Reciclagem")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
	
	@Autowired
    private interItemRepository _itemRepository;

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    @ApiOperation(value="Retorna todas as item")
    public List<Item> Get() {
        return _itemRepository.findAll();
    }
    //Segunda forma  de fazer o crud

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    @ApiOperation(value="Retorna uma item específica informando o id")
    public ResponseEntity<Item> GetById(@PathVariable(value = "codigo") long codigo)
    {
        Optional<Item> item = _itemRepository.findById(codigo);
        if(item.isPresent())
            return new ResponseEntity<Item>(item.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/item", method =  RequestMethod.POST)
    @ApiOperation(value="Adiciona uma item")
    public Item Post(@Valid @RequestBody Item item)
    {
        return _itemRepository.save(item);
    }

    @RequestMapping(value = "/item/{codigo}", method =  RequestMethod.PUT)
    @ApiOperation(value="Altera uma item pelo id")
    public ResponseEntity<Item> Put(@PathVariable(value = "codigo") long codigo, @Valid @RequestBody Item newItem)
    {
        Optional<Item> oldItem = _itemRepository.findById(codigo);
        if(oldItem.isPresent()){
            Item item = oldItem.get();
            item.setQuantidade(newItem.getQuantidade());
            item.setPrecoParcial(newItem.getPrecoParcial());
            _itemRepository.save(item);
            return new ResponseEntity<Item>(item, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/item/{codigo}", method = RequestMethod.DELETE)
    @ApiOperation(value="Deleta uma item pelo id")
    public ResponseEntity<Object> Delete(@PathVariable(value = "codigo") long codigo)
    {
        Optional<Item> item = _itemRepository.findById(codigo);
        if(item.isPresent()){
            _itemRepository.delete(item.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
