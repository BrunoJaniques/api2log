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

import com.best2log.crm.dto.ProdutoDTO;
import com.best2log.crm.entity.Produto;
import com.best2log.crm.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;
    
    @GetMapping
    public ResponseEntity<List<Produto>> getAllProduto() {
        return new ResponseEntity<>(produtoService.getAllProduto(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Integer id) {
        Produto produto = produtoService.getProdutoById(id);
        if (produto != null) {
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(produto, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> saveProduto(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.saveProduto(produto), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Integer id, @RequestBody Produto produto) {
    	return new ResponseEntity<>(produtoService.updateProduto(produto, id), HttpStatus.OK);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable Integer id) {
        Produto produto = produtoService.getProdutoById(id);
        if (produto != null) {
            return new ResponseEntity<>(produtoService.deleteProduto(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(produto, HttpStatus.NOT_FOUND);
        }
    }
    
    // DTOs
    
    @GetMapping("/dto")
    public ResponseEntity<List<ProdutoDTO>> getAllProdutoDTO() {
        return new ResponseEntity<>(produtoService.getAllProdutoDTO(), HttpStatus.OK);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoDTOById(@PathVariable Integer id) {
        ProdutoDTO produtoDTO = produtoService.getProdutoDTOById(id);
        if (produtoDTO != null) {
            return new ResponseEntity<>(produtoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(produtoDTO, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/dto")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProdutoDTO> saveProdutoDTO(@RequestBody ProdutoDTO produtoDTO) {
        return new ResponseEntity<>(produtoService.saveProdutoDTO(produtoDTO), HttpStatus.CREATED);
    }
    
    @PutMapping("/dto/{id}")
    public ResponseEntity<ProdutoDTO> updateProdutoDTO(@PathVariable Integer id, @RequestBody ProdutoDTO produtoDTO) {
    	return new ResponseEntity<>(produtoService.updateProdutoDTO(produtoDTO, id), HttpStatus.OK);
	}
   
}
