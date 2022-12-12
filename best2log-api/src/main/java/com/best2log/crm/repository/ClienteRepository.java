package com.best2log.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.best2log.crm.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
}

