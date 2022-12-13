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
	
	public Endereco getEnderecoById(Integer id) {
		return enderecoRepository.findById(id).orElse(null);
	}
	
	public Endereco saveEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
	}

    public Endereco saveNewEndereco(Endereco endereco) {
    	endereco.ativaStatus();
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
		List<Endereco> listaEndereco = getAllEndereco(); 
		List<EnderecoDTO> listaEnderecoDTO = new ArrayList<>();
		
		// Popula a lista DTO com a lista Entity
		for(Endereco endereco: listaEndereco) {
			EnderecoDTO enderecoDTO = new EnderecoDTO();
			enderecoDTO = enderecoDTO.toDTO(endereco);
			listaEnderecoDTO.add(enderecoDTO);
		}
		return listaEnderecoDTO;
	}
    
    public EnderecoDTO getEnderecoDTOById(Integer id) {
		Endereco endereco = getEnderecoById(id);
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO = enderecoDTO.toDTO(endereco);
		return enderecoDTO;
	}
    
    public EnderecoDTO saveEnderecoDTO(EnderecoDTO enderecoDTO) {
    	Endereco endereco = new Endereco();
    	endereco = saveNewEndereco(endereco.toEntity(enderecoDTO));
    	enderecoDTO = enderecoDTO.toDTO(endereco);
    	return enderecoDTO;
    }
    
    public EnderecoDTO updateEnderecoDTO (EnderecoDTO enderecoDTO, Integer id) {
    	Endereco enderecoExistente = getEnderecoById(id);
    	Endereco enderecoNovo = new Endereco();
    	enderecoNovo = enderecoNovo.toEntity(enderecoDTO);
    	enderecoExistente.setAllAtributos(enderecoNovo);
    	return enderecoDTO.toDTO(saveEndereco(enderecoExistente));
    }

}

