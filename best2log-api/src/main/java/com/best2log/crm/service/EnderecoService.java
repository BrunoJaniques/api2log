package com.best2log.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2log.crm.repository.EnderecoRepository;
import com.best2log.crm.dto.EnderecoDTO;
import com.best2log.crm.entity.Endereco;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

	public List<Endereco> getAllEndereco(){
		return enderecoRepository.findAll(); 
	}
	
	public Endereco getEnderecoById(int id) {
		return enderecoRepository.findById(id).orElse(null);
	}

    public Endereco saveEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
    
    public Endereco updateEndereco(Endereco endereco, Integer id) {
        Endereco enderecoExistente = getEnderecoById(id);
        enderecoExistente.setAllAtributos(endereco);
        return enderecoRepository.save(enderecoExistente);
    }
    
    public Endereco deleteEndereco(Integer id) {
        enderecoRepository.deleteById(id);
        return getEnderecoById(id);
    }
    
    // DTOs
    
    public List<EnderecoDTO> getAllEnderecoDTO(){
		List<Endereco> listaEndereco = enderecoRepository.findAll(); 
		List<EnderecoDTO> listaEnderecoDTO = new ArrayList<>();
		
		// Popula a lista DTO com a lista Entity
		for(Endereco endereco: listaEndereco) {
			EnderecoDTO enderecoDTO = new EnderecoDTO();
			enderecoDTO.toDTO(endereco);
			listaEnderecoDTO.add(enderecoDTO);
		}
		return listaEnderecoDTO;
	}
    
    public EnderecoDTO getEnderecoDTOById(Integer id) {
		Endereco endereco = enderecoRepository.findById(id).orElse(null);
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.toDTO(endereco);
		return enderecoDTO;
	}
    
    public EnderecoDTO saveEnderecoDTO(EnderecoDTO enderecoDTO) {
    	Endereco endereco = new Endereco();
    	endereco = saveEndereco(endereco.toEntity(enderecoDTO));
    	enderecoDTO = enderecoDTO.toDTO(endereco);
    	return enderecoDTO;
    }
    
    public EnderecoDTO updateEnderecoDTO (EnderecoDTO enderecoDTO, Integer id) {
    	Endereco endereco = enderecoRepository.findById(id).orElse(null);
    	endereco = endereco.toEntity(enderecoDTO);
    	return enderecoDTO.toDTO(saveEndereco(endereco));
    }
    

}

