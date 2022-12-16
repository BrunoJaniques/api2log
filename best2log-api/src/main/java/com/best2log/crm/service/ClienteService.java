package com.best2log.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2log.crm.dto.ClienteDTO;
import com.best2log.crm.dto.EnderecoDTO;
import com.best2log.crm.entity.Cliente;
import com.best2log.crm.entity.Endereco;
import com.best2log.crm.repository.ClienteRepository;

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
    
    public Cliente saveNewCliente(Cliente cliente) {
    	cliente.ativaStatus();
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
    
 // DTOs
	
 	public List<ClienteDTO> getAllClienteDTO() {
 		List<Cliente> listaCliente = getAllCliente(); 
 		List<ClienteDTO> listaClienteDTO = new ArrayList<>();
 		System.out.println(listaCliente.size());
 		
 		// Popula a lista DTO com a lista Entity
 		for(Cliente cliente: listaCliente) {
 			ClienteDTO clienteDTO = new ClienteDTO();
 			clienteDTO = toDTO(cliente);
 			listaClienteDTO.add(clienteDTO);
 		}
 		return listaClienteDTO;
 	}

 	public ClienteDTO getClienteDTOById(Integer id) {
 		Cliente cliente = getClienteById(id);
 		ClienteDTO clienteDTO = new ClienteDTO();
 		clienteDTO = toDTO(cliente);
 		return clienteDTO;
     }
 	
 	public ClienteDTO saveClienteDTO(ClienteDTO clienteDTO) {
 		Cliente cliente = new Cliente();
 		cliente = saveNewCliente(toEntity(clienteDTO));
 		clienteDTO = toDTO(cliente);
 		return clienteDTO;
 	}
 	
 	public ClienteDTO updateClienteDTO(ClienteDTO clienteDTO, Integer id){
         Cliente clienteExistente = getClienteById(id);
         Cliente clienteNovo = new Cliente();
         clienteNovo = toEntity(clienteDTO);
         clienteExistente = setAllAtributos(clienteNovo); 
         return toDTO(saveCliente(clienteExistente));
 	}
 	
 	// Set All Atributos
 	
 	public Cliente setAllAtributos(Cliente cliente) {
 		Cliente cli = new Cliente();
 		
 		cli.setNome(cliente.getNome());
 		cli.setCpf(cliente.getCpf());
 		cli.setStatus(cliente.getStatus());
 		cli.setEndereco(cliente.getEndereco());
 		return cli;
 	}
 	
 	// Conversores
 	
 	public ClienteDTO toDTO(Cliente cliente) {
     	ClienteDTO clienteDTO = new ClienteDTO();
 		
 		clienteDTO.setNome(cliente.getNome());
 		clienteDTO.setCpf(cliente.getCpf());
 		clienteDTO.setStatus(cliente.getStatus());
 		if(cliente.getEndereco() != null) {
 			EnderecoDTO enderecoDTO = new EnderecoDTO();
    		enderecoDTO = enderecoDTO.toDTO(cliente.getEndereco());
    		clienteDTO.setEndereco(enderecoDTO);
 		}
     	return clienteDTO;
     }
 	 	
 	public Cliente toEntity(ClienteDTO clienteDTO) {
 		Cliente cliente = new Cliente();
 		Endereco enderecoConvertido = new Endereco();
 		enderecoConvertido = enderecoConvertido.toEntity(clienteDTO.getEndereco());

 		cliente.setNome(clienteDTO.getNome());
 		cliente.setCpf(clienteDTO.getCpf());
 		cliente.setStatus(clienteDTO.getStatus());
 		cliente.setEndereco(enderecoConvertido); 					
 		
 		return cliente;
 	}

}

