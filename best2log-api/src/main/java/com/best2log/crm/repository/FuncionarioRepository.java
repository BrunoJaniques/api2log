package com.best2log.crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.best2log.crm.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	Optional<Funcionario> findByEmailFuncionario(String emailFuncionario);
}