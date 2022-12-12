package com.best2log.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2log.crm.repository.EmpresaParceiraRepository;
import com.best2log.crm.entity.EmpresaParceira;

@Service
public class EmpresaParceiraService {

    @Autowired
    EmpresaParceiraRepository empresaParceiraRepository;

	public List<EmpresaParceira> getAllEmpresaParceira(){
		return empresaParceiraRepository.findAll(); 
	}
	
	public EmpresaParceira getEmpresaParceiraById(int id) {
		return empresaParceiraRepository.findById(id).orElse(null);
	}

    public EmpresaParceira saveEmpresaParceira(EmpresaParceira empresaParceira) {
        return empresaParceiraRepository.save(empresaParceira);
    }
    
    public EmpresaParceira updateEmpresaParceira(EmpresaParceira empresaParceira, Integer id) {
        EmpresaParceira empresaParceiraExistente = getEmpresaParceiraById(id);
        empresaParceiraExistente.setAllAtributos(empresaParceira);
        return empresaParceiraRepository.save(empresaParceiraExistente);
    }
    
    public EmpresaParceira deleteEmpresaParceira(Integer id) {
        empresaParceiraRepository.deleteById(id);
        return getEmpresaParceiraById(id);
    }

}

