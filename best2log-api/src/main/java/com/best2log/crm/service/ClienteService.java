package com.best2log.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2log.crm.repository.ClienteRepository;
import com.best2log.crm.entity.Cliente;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

	public List<Cliente> getAllCliente(){
		return clienteRepository.findAll(); 
	}
	
	public Cliente getClienteById(int id) {
		return clienteRepository.findById(id).orElse(null);
	}

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    public Cliente updateCliente(Cliente cliente, Integer id) {
        Cliente clienteExistente = getClienteById(id);
        clienteExistente.setAllAtributos(cliente);
        return clienteRepository.save(clienteExistente);
    }
    
    public Cliente deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
        return getClienteById(id);
    }

}

