package com.best2log.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2log.crm.dto.EmpresaParceiraDTO;
import com.best2log.crm.dto.EnderecoDTO;
import com.best2log.crm.entity.EmpresaParceira;
import com.best2log.crm.entity.Endereco;
import com.best2log.crm.repository.EmpresaParceiraRepository;

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
    
    public EmpresaParceira saveNewEmpresaParceira(EmpresaParceira empresaParceira) {
        empresaParceira.ativaStatus();
    	return empresaParceiraRepository.save(empresaParceira);
    }
    
    public EmpresaParceira updateEmpresaParceira(EmpresaParceira empresaParceira, Integer id) {
        EmpresaParceira empresaParceiraExistente = getEmpresaParceiraById(id);
        empresaParceiraExistente = setAllAtributos(empresaParceira);
        return empresaParceiraRepository.save(empresaParceiraExistente);
    }
    
    public EmpresaParceira deleteEmpresaParceira(Integer id) {
        empresaParceiraRepository.deleteById(id);
        return getEmpresaParceiraById(id);
    }
    
    // DTOs
	
 	public List<EmpresaParceiraDTO> getAllEmpresaParceiraDTO() {
 		List<EmpresaParceira> listaEmpresaParceira = getAllEmpresaParceira(); 
 		List<EmpresaParceiraDTO> listaEmpresaParceiraDTO = new ArrayList<>();
 		System.out.println(listaEmpresaParceira.size());
 		// Popula a lista DTO com a lista Entity
 		for(EmpresaParceira empresaParceira: listaEmpresaParceira) {
 			EmpresaParceiraDTO empresaParceiraDTO = new EmpresaParceiraDTO();
 			empresaParceiraDTO = toDTO(empresaParceira);
 			listaEmpresaParceiraDTO.add(empresaParceiraDTO);
 		}
 		return listaEmpresaParceiraDTO;
 	}

 	public EmpresaParceiraDTO getEmpresaParceiraDTOById(Integer id) {
 		EmpresaParceira empresaParceira = getEmpresaParceiraById(id);
 		EmpresaParceiraDTO empresaParceiraDTO = new EmpresaParceiraDTO();
 		empresaParceiraDTO = toDTO(empresaParceira);
 		return empresaParceiraDTO;
     }
 	
 	public EmpresaParceiraDTO saveEmpresaParceiraDTO(EmpresaParceiraDTO empresaParceiraDTO) {
 		EmpresaParceira empresaParceira = new EmpresaParceira();
 		empresaParceira = saveNewEmpresaParceira(toEntity(empresaParceiraDTO));
 		empresaParceiraDTO = toDTO(empresaParceira);
 		return empresaParceiraDTO;
 	}
 	
 	public EmpresaParceiraDTO updateEmpresaParceiraDTO(EmpresaParceiraDTO empresaParceiraDTO, Integer id){
         EmpresaParceira empresaParceiraExistente = getEmpresaParceiraById(id);
         EmpresaParceira empresaParceiraNovo = new EmpresaParceira();
         empresaParceiraNovo = toEntity(empresaParceiraDTO);
         empresaParceiraExistente = setAllAtributos(empresaParceiraNovo); 
         return toDTO(saveEmpresaParceira(empresaParceiraExistente));
 	}
 	
 	// Set All Atributos
 	
 	public EmpresaParceira setAllAtributos(EmpresaParceira empresaParceira) {
 		EmpresaParceira empresaTemp = new EmpresaParceira();
 		
		empresaTemp.setNomeEmpresaParceira(empresaParceira.getNomeEmpresaParceira());
		empresaTemp.setRazaoSocial(empresaParceira.getRazaoSocial());
		empresaTemp.setCnpj(empresaParceira.getCnpj());
		empresaTemp.setStatus(empresaParceira.getStatus());
		empresaTemp.setEndereco(empresaParceira.getEndereco());

		return empresaTemp;
    }
 	
 	// Conversores
 	
 	public EmpresaParceiraDTO toDTO(EmpresaParceira empresaParceira) {
     	EmpresaParceiraDTO empresaParceiraDTO = new EmpresaParceiraDTO();
     	
     	empresaParceiraDTO.setIdEmpresaParceira(empresaParceira.getIdEmpresaParceira());
     	empresaParceiraDTO.setNomeEmpresaParceira(empresaParceira.getNomeEmpresaParceira());
     	empresaParceiraDTO.setRazaoSocial(empresaParceira.getRazaoSocial());
     	empresaParceiraDTO.setCnpj(empresaParceira.getCnpj());
     	empresaParceiraDTO.setStatus(empresaParceira.getStatus());
     	if(empresaParceira.getEndereco() != null) {
     		EnderecoDTO enderecoDTO = new EnderecoDTO();
     		enderecoDTO = enderecoDTO.toDTO(empresaParceira.getEndereco());
     		empresaParceiraDTO.setEndereco(enderecoDTO);
     	}	
     	return empresaParceiraDTO;
     }
 	
 	public EmpresaParceira toEntity(EmpresaParceiraDTO empresaParceiraDTO) {
 		EmpresaParceira empresaTemp = new EmpresaParceira();
 		Endereco enderecoConvertido = new Endereco();
 		enderecoConvertido = enderecoConvertido.toEntity(empresaParceiraDTO.getEndereco());

 		empresaTemp.setNomeEmpresaParceira(empresaParceiraDTO.getNomeEmpresaParceira());
		empresaTemp.setRazaoSocial(empresaParceiraDTO.getRazaoSocial());
		empresaTemp.setCnpj(empresaParceiraDTO.getCnpj());
		empresaTemp.setStatus(empresaParceiraDTO.getStatus());
		empresaTemp.setEndereco(enderecoConvertido);

		return empresaTemp;
 	}

}

