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

import com.best2log.crm.entity.CentroDistribuicao;
import com.best2log.crm.service.CentroDistribuicaoService;

@RestController
@RequestMapping("/cd")
public class CentroDistribuicaoController {

    @Autowired
    CentroDistribuicaoService centroDistribuicaoService;
    
    @GetMapping
    public ResponseEntity<List<CentroDistribuicao>> getAllCentroDistribuicao() {
        return new ResponseEntity<>(centroDistribuicaoService.getAllCentroDistribuicao(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CentroDistribuicao> getCentroDistribuicaoById(@PathVariable Integer id) {
        CentroDistribuicao centroDistribuicao = centroDistribuicaoService.getCentroDistribuicaoById(id);
        if (centroDistribuicao != null) {
            return new ResponseEntity<>(centroDistribuicao, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(centroDistribuicao, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CentroDistribuicao> saveCentroDistribuicao(@RequestBody CentroDistribuicao centroDistribuicao) {
        return new ResponseEntity<>(centroDistribuicaoService.saveCentroDistribuicao(centroDistribuicao), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CentroDistribuicao> updateCentroDistribuicao(@PathVariable Integer id, @RequestBody CentroDistribuicao centroDistribuicao) {
    	return new ResponseEntity<>(centroDistribuicaoService.updateCentroDistribuicao(centroDistribuicao, id), HttpStatus.OK);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<CentroDistribuicao> deleteCentroDistribuicao(@PathVariable Integer id) {
        CentroDistribuicao centroDistribuicao = centroDistribuicaoService.getCentroDistribuicaoById(id);
        if (centroDistribuicao != null) {
            return new ResponseEntity<>(centroDistribuicaoService.deleteCentroDistribuicao(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(centroDistribuicao, HttpStatus.NOT_FOUND);
        }
    }
    
}
