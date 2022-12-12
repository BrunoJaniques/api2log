package com.best2log.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2log.crm.repository.OrdemDeEntregaRepository;
import com.best2log.crm.entity.OrdemDeEntrega;

@Service
public class OrdemDeEntregaService {

    @Autowired
    OrdemDeEntregaRepository ordemDeEntregaRepository;

	public List<OrdemDeEntrega> getAllOrdemDeEntrega(){
		return ordemDeEntregaRepository.findAll(); 
	}
	
	public OrdemDeEntrega getOrdemDeEntregaById(int id) {
		return ordemDeEntregaRepository.findById(id).orElse(null);
	}

    public OrdemDeEntrega saveOrdemDeEntrega(OrdemDeEntrega ordemDeEntrega) {
        return ordemDeEntregaRepository.save(ordemDeEntrega);
    }
    
    public OrdemDeEntrega updateOrdemDeEntrega(OrdemDeEntrega ordemDeEntrega, Integer id) {
        OrdemDeEntrega ordemDeEntregaExistente = getOrdemDeEntregaById(id);
        ordemDeEntregaExistente.setAllAtributos(ordemDeEntrega);
        return ordemDeEntregaRepository.save(ordemDeEntregaExistente);
    }
    
    public OrdemDeEntrega deleteOrdemDeEntrega(Integer id) {
        ordemDeEntregaRepository.deleteById(id);
        return getOrdemDeEntregaById(id);
    }

}

