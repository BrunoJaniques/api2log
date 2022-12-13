package com.best2log.crm.dto;

import com.best2log.crm.entity.Funcionario;
import com.best2log.crm.entity.Status;

public class FuncionarioDTO {

	private String nomeFuncionario;
	private EnderecoDTO endereco;
	private String cpf;
	private String rg;
	private String login;
	private String senha;
	private String funcao;
	private Status status;
	private Integer idFuncionario;

	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public FuncionarioDTO toDTO(Funcionario funcionario) {
    	FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
    	EnderecoDTO enderecoConvertido = new EnderecoDTO();
    	enderecoConvertido = enderecoConvertido.toDTO(funcionario.getEndereco());
    	
    	funcionarioDTO.setIdFuncionario(funcionario.getIdFuncionario());
    	funcionarioDTO.setEndereco(enderecoConvertido);
    	funcionarioDTO.setCpf(funcionario.getCpfFuncionario());
    	funcionarioDTO.setRg(funcionario.getRgFuncionario());
    	funcionarioDTO.setLogin(funcionario.getEmailFuncionario());
    	funcionarioDTO.setSenha(funcionario.getSenhaFuncionario());
//    	funcionarioDTO.setFuncao(funcionario.getFuncaoFuncionario());
    	funcionarioDTO.setStatus(funcionario.getStatusFuncionario());
    	return funcionarioDTO;
    }
	
}
