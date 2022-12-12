package com.best2log.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2log.crm.repository.EnderecoRepository;
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

}

