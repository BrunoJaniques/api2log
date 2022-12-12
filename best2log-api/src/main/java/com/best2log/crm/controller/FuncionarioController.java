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

import com.best2log.crm.entity.Funcionario;
import com.best2log.crm.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;
    
    @GetMapping
    public ResponseEntity<List<Funcionario>> getAllFuncionario() {
        return new ResponseEntity<>(funcionarioService.getAllFuncionario(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Integer id) {
        Funcionario funcionario = funcionarioService.getFuncionarioById(id);
        if (funcionario != null) {
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(funcionario, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Funcionario> saveFuncionario(@RequestBody Funcionario funcionario) {
        return new ResponseEntity<>(funcionarioService.saveFuncionario(funcionario), HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Integer id, @RequestBody Funcionario funcionario) {
//		Optional<Funcionario> dadosFuncionario = funcionarioService.updateFuncionario(funcionario, id);
//		if (!dadosFuncionario.isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//		funcionario.setIdFuncionario(id);
//		funcionarioService.saveFuncionario(funcionario);
//		return ResponseEntity.ok(dadosFuncionario.get());
//	}
    
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Integer id, @RequestBody Funcionario funcionario) {
    	return new ResponseEntity<>(funcionarioService.updateFuncionario(funcionario, id), HttpStatus.OK);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deleteFuncionario(@PathVariable Integer id) {
        Funcionario funcionario = funcionarioService.getFuncionarioById(id);
        if (funcionario != null) {
            return new ResponseEntity<>(funcionarioService.deleteFuncionario(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(funcionario, HttpStatus.NOT_FOUND);
        }
    }
}
