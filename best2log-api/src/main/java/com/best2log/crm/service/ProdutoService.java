package com.best2log.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2log.crm.dto.ProdutoDTO;
import com.best2log.crm.entity.Produto;
import com.best2log.crm.repository.ProdutoRepository;

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
    
    public Produto saveNewProduto(Produto produto) {
    	produto.ativaStatus();
        return produtoRepository.save(produto);
    }
    
    public Produto updateProduto(Produto produto, Integer id) {
        Produto produtoExistente = getProdutoById(id);
        produtoExistente = setAllAtributos(produto);
        return produtoRepository.save(produtoExistente);
    }
    
    public Produto deleteProduto(Integer id) {
        produtoRepository.deleteById(id);
        return getProdutoById(id);
    }
    
// DTOs
    
    public List<ProdutoDTO> getAllProdutoDTO(){
		List<Produto> listaProduto = getAllProduto(); 
		List<ProdutoDTO> listaProdutoDTO = new ArrayList<>();
		
		// Popula a lista DTO com a lista Entity
		for(Produto produto: listaProduto) {
			ProdutoDTO produtoDTO = new ProdutoDTO();
			produtoDTO = toDTO(produto);
			listaProdutoDTO.add(produtoDTO);
		}
		return listaProdutoDTO;
	}
    
    public ProdutoDTO getProdutoDTOById(Integer id) {
		Produto produto = getProdutoById(id);
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO = toDTO(produto);
		return produtoDTO;
	}
    
    public ProdutoDTO saveProdutoDTO(ProdutoDTO produtoDTO) {
    	Produto produto = new Produto();
    	produto = saveNewProduto(toEntity(produtoDTO));
    	produtoDTO = toDTO(produto);
    	return produtoDTO;
    }
    
    public ProdutoDTO updateProdutoDTO (ProdutoDTO produtoDTO, Integer id) {
    	Produto produtoExistente = getProdutoById(id);
    	Produto produtoNovo = new Produto();
    	produtoNovo = toEntity(produtoDTO);
    	produtoExistente = setAllAtributos(produtoNovo);
    	return toDTO(saveProduto(produtoExistente));
    }
    
    // SetAllAtributos
    
    public Produto setAllAtributos(Produto produto) {
    	Produto produtoTemp = new Produto();
    	produtoTemp.setNomeProduto(produto.getNomeProduto());
    	produtoTemp.setCodigo(produto.getCodigo());
    	produtoTemp.setCategoria(produto.getCategoria());
    	produtoTemp.setValor(produto.getValor());
    	produtoTemp.setStatus(produto.getStatus());
//    	produtoTemp.setEntregasProdutos(produto.getEntregasProdutos());
    	
    	return produtoTemp;
    }
    
    // Conversores
    
    public Produto toEntity(ProdutoDTO produtoDTO) {
    	Produto produto = new Produto();
    	produto.setNomeProduto(produtoDTO.getNomeProduto());
    	produto.setCodigo(produtoDTO.getCodigo());
    	produto.setCategoria(produtoDTO.getCategoria());
    	produto.setValor(produtoDTO.getValor());
    	produto.setStatus(produtoDTO.getStatus());
    	
    	return produto;
    }
    
    public ProdutoDTO toDTO(Produto produto) {
    	ProdutoDTO produtoDTO = new ProdutoDTO();
    	produtoDTO.setId_produto(produto.getId_produto());
    	produtoDTO.setNomeProduto(produto.getNomeProduto());
    	produtoDTO.setCodigo(produto.getCodigo());
    	produtoDTO.setCategoria(produto.getCategoria());
    	produtoDTO.setValor(produto.getValor());
    	produtoDTO.setStatus(produto.getStatus());
    	
    	return produtoDTO;
    }

}

