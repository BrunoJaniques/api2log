package com.best2log.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2log.crm.repository.EntregaProdutoRepository;
import com.best2log.crm.entity.EntregaProduto;

@Service
public class EntregaProdutoService {

    @Autowired
    EntregaProdutoRepository entregaProdutoRepository;

	public List<EntregaProduto> getAllEntregaProduto(){
		return entregaProdutoRepository.findAll(); 
	}
	
	public EntregaProduto getEntregaProdutoById(int id) {
		return entregaProdutoRepository.findById(id).orElse(null);
	}

    public EntregaProduto saveEntregaProduto(EntregaProduto entregaProduto) {
        return entregaProdutoRepository.save(entregaProduto);
    }
    
    public EntregaProduto updateEntregaProduto(EntregaProduto entregaProduto, Integer id) {
        EntregaProduto entregaProdutoExistente = getEntregaProdutoById(id);
        entregaProdutoExistente.setAllAtributos(entregaProduto);
        return entregaProdutoRepository.save(entregaProdutoExistente);
    }
    
    public EntregaProduto deleteEntregaProduto(Integer id) {
        entregaProdutoRepository.deleteById(id);
        return getEntregaProdutoById(id);
    }

}

