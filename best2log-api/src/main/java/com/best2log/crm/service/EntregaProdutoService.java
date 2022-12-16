package com.best2log.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2log.crm.dto.EntregaProdutoDTO;
import com.best2log.crm.entity.EntregaProduto;
import com.best2log.crm.repository.EntregaProdutoRepository;

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
    
    public EntregaProduto saveNewEntregaProduto(EntregaProduto entregaProduto) {
    	entregaProduto.ativaStatusAguardando();
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
    
// DTOs
    
    public List<EntregaProdutoDTO> getAllEntregaProdutoDTO(){
		List<EntregaProduto> listaEntregaProduto = getAllEntregaProduto();
		List<EntregaProdutoDTO> listaEntregaProdutoDTO = new ArrayList<>();
		
		// Popula a lista DTO com a lista Entity
		for(EntregaProduto EntregaProduto: listaEntregaProduto) {
			EntregaProdutoDTO EntregaProdutoDTO = new EntregaProdutoDTO();
			EntregaProdutoDTO = toDTO(EntregaProduto);
			listaEntregaProdutoDTO.add(EntregaProdutoDTO);
		}
		return listaEntregaProdutoDTO;
	}
    
    public EntregaProdutoDTO getEntregaProdutoDTOById(Integer id) {
		EntregaProduto entregaProduto = getEntregaProdutoById(id);
		EntregaProdutoDTO entregaProdutoDTO = new EntregaProdutoDTO();
		entregaProdutoDTO = toDTO(entregaProduto);
		return entregaProdutoDTO;
	}
    
    public EntregaProdutoDTO saveEntregaProdutoDTO(EntregaProdutoDTO entregaProdutoDTO) {
    	EntregaProduto entregaProduto = new EntregaProduto();
    	entregaProduto = saveNewEntregaProduto(toEntity(entregaProdutoDTO));
    	entregaProdutoDTO = toDTO(entregaProduto);
    	return entregaProdutoDTO;
    }
    
    public EntregaProdutoDTO updateProdutoDTO (EntregaProdutoDTO entregaProdutoDTO, Integer id) {
    	EntregaProduto entregaProdutoExistente = getEntregaProdutoById(id);
    	EntregaProduto entregaProdutoNovo = new EntregaProduto();
    	entregaProdutoNovo = toEntity(entregaProdutoDTO);
    	entregaProdutoExistente = setAllAtributos(entregaProdutoNovo);
    	return toDTO(saveEntregaProduto(entregaProdutoExistente));
    }
    
    // SetAllAtributos
    
    public EntregaProduto setAllAtributos(EntregaProduto entregaProduto) {
    	EntregaProduto entregaProdutoTemp = new EntregaProduto();
    	entregaProdutoTemp.setCliente(null);
    	
    	return entregaProdutoTemp;
    }
    
    // Conversores
    
    public EntregaProduto toEntity(EntregaProdutoDTO entregaProdutoDTO) {
    	EntregaProduto entregaProduto = new EntregaProduto();
    	entregaProduto.setQuantidade(entregaProdutoDTO.getQuantidade());
    	entregaProduto.setValorLiquido(entregaProdutoDTO.getValorLiquido());
    	entregaProduto.setDataArmazenamento(entregaProdutoDTO.getDataArmazenamento());
    	entregaProduto.setLocalizacaoEstoque(entregaProdutoDTO.getLocalizacaoEstoque());
    	entregaProduto.setStatus(entregaProdutoDTO.getStatus());
    	
    	return entregaProduto;
    }
    
    public EntregaProdutoDTO toDTO(EntregaProduto entregaProduto) {
    	EntregaProdutoDTO entregaProdutoDTO = new EntregaProdutoDTO();
    	entregaProdutoDTO.setIdEntregaProduto(entregaProduto.getIdEntregaProduto());
    	entregaProdutoDTO.setQuantidade(entregaProduto.getQuantidade());
    	entregaProdutoDTO.setValorLiquido(entregaProduto.getValorLiquido());
    	entregaProdutoDTO.setDataArmazenamento(entregaProduto.getDataArmazenamento());
    	entregaProdutoDTO.setLocalizacaoEstoque(entregaProduto.getLocalizacaoEstoque());
    	entregaProdutoDTO.setStatus(entregaProduto.getStatus());
    	
    	return entregaProdutoDTO;
    }

}

