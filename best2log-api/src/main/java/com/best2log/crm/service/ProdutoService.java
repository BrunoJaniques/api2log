package com.best2log.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2log.crm.repository.ProdutoRepository;
import com.best2log.crm.entity.Produto;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

	public List<Produto> getAllProduto(){
		return produtoRepository.findAll(); 
	}
	
	public Produto getProdutoById(int id) {
		return produtoRepository.findById(id).orElse(null);
	}

    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
    
    public Produto updateProduto(Produto produto, Integer id) {
        Produto produtoExistente = getProdutoById(id);
        produtoExistente.setAllAtributos(produto);
        return produtoRepository.save(produtoExistente);
    }
    
    public Produto deleteProduto(Integer id) {
        produtoRepository.deleteById(id);
        return getProdutoById(id);
    }

}

