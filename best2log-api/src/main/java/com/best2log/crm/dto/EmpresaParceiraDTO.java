package com.best2log.crm.dto;

import com.best2log.crm.entity.Status;

public class EmpresaParceiraDTO {

	private Integer idEmpresaParceira;
    private String nomeEmpresaParceira;
    private String razaoSocial;
    private String cnpj;
    private Status status;
    private EnderecoDTO endereco;
	
    //Getters and Setters
    
    public Integer getIdEmpresaParceira() {
		return idEmpresaParceira;
	}
	public void setIdEmpresaParceira(Integer idEmpresaParceira) {
		this.idEmpresaParceira = idEmpresaParceira;
	}
	public String getNomeEmpresaParceira() {
		return nomeEmpresaParceira;
	}
	public void setNomeEmpresaParceira(String nomeEmpresaParceira) {
		this.nomeEmpresaParceira = nomeEmpresaParceira;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
    
}
