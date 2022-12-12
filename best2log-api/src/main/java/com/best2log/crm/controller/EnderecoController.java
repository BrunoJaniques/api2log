package com.best2log.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.best2log.crm.entity.Endereco;
import com.best2log.crm.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;
    
    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEndereco() {
        return new ResponseEntity<>(enderecoService.getAllEndereco(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Integer id) {
        Endereco endereco = enderecoService.getEnderecoById(id);
        if (endereco != null) {
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(endereco, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Endereco> saveEndereco(@RequestBody Endereco endereco) {
        return new ResponseEntity<>(enderecoService.saveEndereco(endereco), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Integer id, @RequestBody Endereco endereco) {
    	return new ResponseEntity<>(enderecoService.updateEndereco(endereco, id), HttpStatus.OK);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Endereco> deleteEndereco(@PathVariable Integer id) {
        Endereco endereco = enderecoService.getEnderecoById(id);
        if (endereco != null) {
            return new ResponseEntity<>(enderecoService.deleteEndereco(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(endereco, HttpStatus.NOT_FOUND);
        }
    }
    
}
