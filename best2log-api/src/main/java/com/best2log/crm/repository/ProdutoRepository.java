package com.best2log.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.best2log.crm.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
}

