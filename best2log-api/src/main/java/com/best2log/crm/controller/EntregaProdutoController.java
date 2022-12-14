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

import com.best2log.crm.dto.EntregaProdutoDTO;
import com.best2log.crm.dto.ProdutoDTO;
import com.best2log.crm.entity.EntregaProduto;
import com.best2log.crm.service.EntregaProdutoService;

@RestController
@RequestMapping("/entrega_produto")
public class EntregaProdutoController {

    @Autowired
    EntregaProdutoService entregaProdutoService;
    
    @GetMapping
    public ResponseEntity<List<EntregaProduto>> getAllEntregaProduto() {
        return new ResponseEntity<>(entregaProdutoService.getAllEntregaProduto(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaProduto> getEntregaProdutoById(@PathVariable Integer id) {
        EntregaProduto entregaProduto = entregaProdutoService.getEntregaProdutoById(id);
        if (entregaProduto != null) {
            return new ResponseEntity<>(entregaProduto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(entregaProduto, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EntregaProduto> saveEntregaProduto(@RequestBody EntregaProduto entregaProduto) {
        return new ResponseEntity<>(entregaProdutoService.saveEntregaProduto(entregaProduto), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EntregaProduto> updateEntregaProduto(@PathVariable Integer id, @RequestBody EntregaProduto entregaProduto) {
    	return new ResponseEntity<>(entregaProdutoService.updateEntregaProduto(entregaProduto, id), HttpStatus.OK);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<EntregaProduto> deleteEntregaProduto(@PathVariable Integer id) {
        EntregaProduto entregaProduto = entregaProdutoService.getEntregaProdutoById(id);
        if (entregaProduto != null) {
            return new ResponseEntity<>(entregaProdutoService.deleteEntregaProduto(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(entregaProduto, HttpStatus.NOT_FOUND);
        }
    }
    
    // DTOs
    
//    @GetMapping("/dto")
//    public ResponseEntity<List<EntregaProdutoDTO>> getAllEntregaProdutoDTO() {
//        return new ResponseEntity<>(entregaProdutoService.getAllEntregaProdutoDTO(), HttpStatus.OK);
//    }
//
//    @GetMapping("/dto/{id}")
//    public ResponseEntity<EntregaProdutoDTO> getEntregaProdutoDTOById(@PathVariable Integer id) {
//        EntregaProdutoDTO entregaProdutoDTO = entregaProdutoService.getEntregaProdutoDTOById(id);
//        if (entregaProdutoDTO != null) {
//            return new ResponseEntity<>(entregaProdutoDTO, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(entregaProdutoDTO, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/dto")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<EntregaProdutoDTO> saveEntregaProdutoDTO(@RequestBody EntregaProdutoDTO entregaProdutoDTO) {
//        return new ResponseEntity<>(entregaProdutoService.saveEntregaProdutoDTO(entregaProdutoDTO), HttpStatus.CREATED);
//    }
//    
//    @PutMapping("/dto/{id}")
//    public ResponseEntity<EntregaProdutoDTO> updateEntregaProdutoDTO(@PathVariable Integer id, @RequestBody EntregaProdutoDTO entregaProdutoDTO) {
//    	return new ResponseEntity<>(entregaProdutoService.updateEntregaProdutoDTO(entregaProdutoDTO, id), HttpStatus.OK);
//	}
    
}
