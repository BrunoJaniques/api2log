package com.best2log.crm.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2log.crm.dto.EnderecoDTO;
import com.best2log.crm.dto.FuncionarioDTO;
import com.best2log.crm.entity.Endereco;
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

	public Funcionario saveNewFuncionario(Funcionario funcionario) {
		funcionario.ativaStatus();
		return funcionarioRepository.save(funcionario);
	}
	
	public Funcionario updateFuncionario(Funcionario funcionario, Integer id){
        Funcionario funcionarioExistenteNoBanco = getFuncionarioById(id);
        funcionarioExistenteNoBanco = setAllAtributos(funcionario);
        return saveFuncionario(funcionarioExistenteNoBanco);
    }

	public Funcionario deleteFuncionario(Integer id) {
		funcionarioRepository.deleteById(id);
		return getFuncionarioById(id);
	}
	
	// DTOs
	
	public List<FuncionarioDTO> getAllFuncionarioDTO() {
		List<Funcionario> listaFuncionario = getAllFuncionario(); 
		List<FuncionarioDTO> listaFuncionarioDTO = new ArrayList<>();
		System.out.println(listaFuncionario.size());
		// Popula a lista DTO com a lista Entity
		for(Funcionario funcionario: listaFuncionario) {
			FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
			funcionarioDTO = toDTO(funcionario);
			listaFuncionarioDTO.add(funcionarioDTO);
		}
		return listaFuncionarioDTO;
	}

	public FuncionarioDTO getFuncionarioDTOById(Integer id) {
		Funcionario funcionario = getFuncionarioById(id);
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		funcionarioDTO = toDTO(funcionario);
		return funcionarioDTO;
    }
	
	public FuncionarioDTO saveFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
		Funcionario funcionario = new Funcionario();
		funcionario = saveNewFuncionario(toEntity(funcionarioDTO));
		funcionarioDTO = toDTO(funcionario);
		return funcionarioDTO;
	}
	
	public FuncionarioDTO updateFuncionarioDTO(FuncionarioDTO funcionarioDTO, Integer id){
        Funcionario funcionarioExistente = getFuncionarioById(id);
        Funcionario funcionarioNovo = new Funcionario();
        funcionarioNovo = toEntity(funcionarioDTO);
        funcionarioExistente = setAllAtributos(funcionarioNovo); 
        return toDTO(saveFuncionario(funcionarioExistente));
	}
	
	// Set All Atributos
	
	public Funcionario setAllAtributos(Funcionario funcionario) {
		Funcionario func = new Funcionario();
		
		func.setNomeFuncionario(funcionario.getNomeFuncionario());
		func.setEndereco(funcionario.getEndereco());
		func.setCpfFuncionario(funcionario.getCpfFuncionario());
		func.setRgFuncionario(funcionario.getRgFuncionario());
		func.setEmailFuncionario(funcionario.getEmailFuncionario());
//		func.setSenhaFuncionario(funcionario.getSenhaFuncionario());
		func.setFuncaoFuncionario(funcionario.getFuncaoFuncionario());
		func.setStatusFuncionario(funcionario.getStatusFuncionario());
		
		return func;
	}
	
	// Conversores
	
	public FuncionarioDTO toDTO(Funcionario funcionario) {
    	FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
    	
    	funcionarioDTO.setIdFuncionario(funcionario.getIdFuncionario());
    	funcionarioDTO.setNomeFuncionario(funcionario.getNomeFuncionario());
    	if(funcionario.getEndereco() != null) {
    		EnderecoDTO enderecoDTO = new EnderecoDTO();
    		enderecoDTO = enderecoDTO.toDTO(funcionario.getEndereco());
    		funcionarioDTO.setEndereco(enderecoDTO);
    	}	
    	funcionarioDTO.setCpf(funcionario.getCpfFuncionario());
    	funcionarioDTO.setRg(funcionario.getRgFuncionario());
    	funcionarioDTO.setLogin(funcionario.getEmailFuncionario());
    	funcionarioDTO.setFuncao(funcionario.getFuncaoFuncionario());
    	funcionarioDTO.setStatus(funcionario.getStatusFuncionario());
    	return funcionarioDTO;
    }
	
	public Funcionario toEntity(FuncionarioDTO funcionarioDTO) {
		Funcionario funcionario = new Funcionario();
		Endereco enderecoConvertido = new Endereco();
		enderecoConvertido = enderecoConvertido.toEntity(funcionarioDTO.getEndereco());

		funcionario.setNomeFuncionario(funcionarioDTO.getNomeFuncionario());
		funcionario.setEndereco(enderecoConvertido);
		funcionario.setCpfFuncionario(funcionarioDTO.getCpf());
		funcionario.setRgFuncionario(funcionarioDTO.getRg());
		funcionario.setEmailFuncionario(funcionarioDTO.getLogin());
//		funcionario.setSenhaFuncionario(funcionarioDTO.getSenha());
//    	funcionario.setFuncao(funcionarioDTO.getFuncao());
		funcionario.setStatusFuncionario(funcionarioDTO.getStatus());
		return funcionario;
		
	}
	
}

