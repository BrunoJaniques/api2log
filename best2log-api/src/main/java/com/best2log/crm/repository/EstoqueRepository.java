package com.best2log.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.best2log.crm.entity.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
	
}

