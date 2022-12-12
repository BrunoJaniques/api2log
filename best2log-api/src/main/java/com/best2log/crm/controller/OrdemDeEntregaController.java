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

import com.best2log.crm.entity.OrdemDeEntrega;
import com.best2log.crm.service.OrdemDeEntregaService;

@RestController
@RequestMapping("/ordem")
public class OrdemDeEntregaController {

    @Autowired
    OrdemDeEntregaService ordemDeEntregaService;
    
    @GetMapping
    public ResponseEntity<List<OrdemDeEntrega>> getAllOrdemDeEntrega() {
        return new ResponseEntity<>(ordemDeEntregaService.getAllOrdemDeEntrega(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemDeEntrega> getOrdemDeEntregaById(@PathVariable Integer id) {
        OrdemDeEntrega ordemDeEntrega = ordemDeEntregaService.getOrdemDeEntregaById(id);
        if (ordemDeEntrega != null) {
            return new ResponseEntity<>(ordemDeEntrega, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ordemDeEntrega, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrdemDeEntrega> saveOrdemDeEntrega(@RequestBody OrdemDeEntrega ordemDeEntrega) {
        return new ResponseEntity<>(ordemDeEntregaService.saveOrdemDeEntrega(ordemDeEntrega), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<OrdemDeEntrega> updateOrdemDeEntrega(@PathVariable Integer id, @RequestBody OrdemDeEntrega ordemDeEntrega) {
    	return new ResponseEntity<>(ordemDeEntregaService.updateOrdemDeEntrega(ordemDeEntrega, id), HttpStatus.OK);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<OrdemDeEntrega> deleteOrdemDeEntrega(@PathVariable Integer id) {
        OrdemDeEntrega ordemDeEntrega = ordemDeEntregaService.getOrdemDeEntregaById(id);
        if (ordemDeEntrega != null) {
            return new ResponseEntity<>(ordemDeEntregaService.deleteOrdemDeEntrega(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ordemDeEntrega, HttpStatus.NOT_FOUND);
        }
    }
    
}
