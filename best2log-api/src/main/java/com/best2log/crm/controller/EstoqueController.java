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

import com.best2log.crm.entity.Estoque;
import com.best2log.crm.service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    EstoqueService estoqueService;
    
    @GetMapping
    public ResponseEntity<List<Estoque>> getAllEstoque() {
        return new ResponseEntity<>(estoqueService.getAllEstoque(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> getEstoqueById(@PathVariable Integer id) {
        Estoque estoque = estoqueService.getEstoqueById(id);
        if (estoque != null) {
            return new ResponseEntity<>(estoque, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(estoque, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Estoque> saveEstoque(@RequestBody Estoque estoque) {
        return new ResponseEntity<>(estoqueService.saveEstoque(estoque), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Estoque> updateEstoque(@PathVariable Integer id, @RequestBody Estoque estoque) {
    	return new ResponseEntity<>(estoqueService.updateEstoque(estoque, id), HttpStatus.OK);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Estoque> deleteEstoque(@PathVariable Integer id) {
        Estoque estoque = estoqueService.getEstoqueById(id);
        if (estoque != null) {
            return new ResponseEntity<>(estoqueService.deleteEstoque(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(estoque, HttpStatus.NOT_FOUND);
        }
    }
    
}
