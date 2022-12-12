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

import com.best2log.crm.entity.EmpresaParceira;
import com.best2log.crm.service.EmpresaParceiraService;

@RestController
@RequestMapping("/empresa_parceira")
public class EmpresaParceiraController {

    @Autowired
    EmpresaParceiraService empresaParceiraService;
    
    @GetMapping
    public ResponseEntity<List<EmpresaParceira>> getAllEmpresaParceira() {
        return new ResponseEntity<>(empresaParceiraService.getAllEmpresaParceira(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaParceira> getEmpresaParceiraById(@PathVariable Integer id) {
        EmpresaParceira empresaParceira = empresaParceiraService.getEmpresaParceiraById(id);
        if (empresaParceira != null) {
            return new ResponseEntity<>(empresaParceira, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(empresaParceira, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmpresaParceira> saveEmpresaParceira(@RequestBody EmpresaParceira empresaParceira) {
        return new ResponseEntity<>(empresaParceiraService.saveEmpresaParceira(empresaParceira), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EmpresaParceira> updateEmpresaParceira(@PathVariable Integer id, @RequestBody EmpresaParceira empresaParceira) {
    	return new ResponseEntity<>(empresaParceiraService.updateEmpresaParceira(empresaParceira, id), HttpStatus.OK);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<EmpresaParceira> deleteEmpresaParceira(@PathVariable Integer id) {
        EmpresaParceira empresaParceira = empresaParceiraService.getEmpresaParceiraById(id);
        if (empresaParceira != null) {
            return new ResponseEntity<>(empresaParceiraService.deleteEmpresaParceira(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(empresaParceira, HttpStatus.NOT_FOUND);
        }
    }
    
}
