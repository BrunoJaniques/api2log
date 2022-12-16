package com.best2log.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.best2log.crm.dto.ClienteDTO;
import com.best2log.crm.dto.FuncionarioDTO;
import com.best2log.crm.entity.Cliente;
import com.best2log.crm.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllCliente() {
        return new ResponseEntity<>(clienteService.getAllCliente(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
        Cliente cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.saveCliente(cliente), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
    	return new ResponseEntity<>(clienteService.updateCliente(cliente, id), HttpStatus.OK);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Integer id) {
        Cliente cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            return new ResponseEntity<>(clienteService.deleteCliente(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }
    }
    
// DTOs
    
    @GetMapping("/dto")
    public ResponseEntity<List<ClienteDTO>> getAllClienteDTO() {
        return new ResponseEntity<>(clienteService.getAllClienteDTO(), HttpStatus.OK);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<ClienteDTO> getClienteDTOById(@PathVariable Integer id) {
        ClienteDTO clienteDTO = clienteService.getClienteDTOById(id);
        if (clienteDTO != null) {
            return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(clienteDTO, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/dto")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteDTO> saveClienteDTO(@RequestBody ClienteDTO clienteDTO) {
        return new ResponseEntity<>(clienteService.saveClienteDTO(clienteDTO), HttpStatus.CREATED);
    }

    @PutMapping("/dto/{id}")
    public ResponseEntity<ClienteDTO> updateClienteDTO(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
    	return new ResponseEntity<>(clienteService.updateClienteDTO(clienteDTO, id), HttpStatus.OK);
	}
    
}
