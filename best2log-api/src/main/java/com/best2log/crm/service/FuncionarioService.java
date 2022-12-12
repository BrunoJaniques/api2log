package com.best2log.crm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2log.crm.entity.Funcionario;
import com.best2log.crm.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	public List<Funcionario> getAllFuncionario() {
		return funcionarioRepository.findAll();
	}

	public Funcionario getFuncionarioById(Integer id) {
		return funcionarioRepository.findById(id).orElse(null);
	}
	
	public Funcionario findByEmail(String email){
        return funcionarioRepository.findByEmailFuncionario(email).get();
    }
	
	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public Funcionario updateFuncionario(Funcionario funcionario, Integer id){
        Funcionario funcionarioExistenteNoBanco = getFuncionarioById(id);
        funcionarioExistenteNoBanco.setAllAtributos(funcionario);
        return funcionarioRepository.save(funcionarioExistenteNoBanco);
    }

	public Funcionario deleteFuncionario(Integer id) {
		funcionarioRepository.deleteById(id);
		return getFuncionarioById(id);
	}
}

