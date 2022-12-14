package com.best2log.crm.dto;

import com.best2log.crm.entity.Endereco;
import com.best2log.crm.entity.Status;

public class EnderecoDTO {
	
	private Integer idEndereco;
	private String cep;
	private String estado;
	private String cidade;
	private String bairro;
	private String logradouro;
	private String numero;
	private String complemento;
	private Status ativo; 
	
	public Integer getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	public Status getAtivo() {
		return ativo;
	}
	public void setAtivo(Status ativo) {
		this.ativo = ativo;
	}
	
	public EnderecoDTO toDTO(Endereco endereco) {
    	EnderecoDTO enderecoDTO = new EnderecoDTO();
    	enderecoDTO.setIdEndereco(endereco.getIdEndereco());
    	enderecoDTO.setCep(endereco.getCep());
    	enderecoDTO.setEstado(endereco.getEstado());
    	enderecoDTO.setCidade(endereco.getCidade());
    	enderecoDTO.setBairro(endereco.getBairro());
    	enderecoDTO.setLogradouro(endereco.getLogradouro());
    	enderecoDTO.setNumero(endereco.getNumero());
    	enderecoDTO.setComplemento(endereco.getComplemento());
    	enderecoDTO.setAtivo(endereco.getAtivo());
    	return enderecoDTO;
    }
	
}
