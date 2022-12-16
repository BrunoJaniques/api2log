package com.best2log.crm.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.best2log.crm.dto.EnderecoDTO;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Integer idEndereco;

	@Column(name = "cep")
	private String cep;
	
	@Column(name = "estado")
	private String estado;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "numero")
	private String numero;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "ativo")
	private Status ativo;
	
//	@OneToMany(mappedBy = "endereco")
//	private Set<Funcionario> funcionarios;

//	@OneToMany(mappedBy = "endereco")
//	private Set<EmpresaParceira> empresasParceiras;
	
//	@OneToMany(mappedBy = "endereco")
//	private Set<Cliente> clientes;
	
	@OneToMany(mappedBy = "endereco")
	private Set<CentroDistribuicao> centrosDistribuicao;

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
	
	public void ativaStatus() {
		this.ativo = ativo.ATIVO;
	}

//	public Set<Funcionario> getFuncionarios() {
//		return funcionarios;
//	}
//
//	public void setFuncionarios(Set<Funcionario> funcionarios) {
//		this.funcionarios = funcionarios;
//	}

//	public Set<EmpresaParceira> getEmpresasParceiras() {
//		return empresasParceiras;
//	}
//
//	public void setEmpresasParceiras(Set<EmpresaParceira> empresasParceiras) {
//		this.empresasParceiras = empresasParceiras;
//	}

//	public Set<Cliente> getClientes() {
//		return clientes;
//	}
//
//	public void setClientes(Set<Cliente> clientes) {
//		this.clientes = clientes;
//	}

	public Set<CentroDistribuicao> getCentrosDistribuicao() {
		return centrosDistribuicao;
	}

	public void setCentrosDistribuicao(Set<CentroDistribuicao> centrosDistribuicao) {
		this.centrosDistribuicao = centrosDistribuicao;
	}

	public void setAllAtributos(Endereco endereco) {
		this.setCep(endereco.getCep());
		this.setEstado(endereco.getEstado());
		this.setCidade(endereco.getCidade());
		this.setBairro(endereco.getBairro());
		this.setLogradouro(endereco.getLogradouro());
		this.setNumero(endereco.getNumero());
		this.setComplemento(endereco.getComplemento());
		this.setAtivo(endereco.getAtivo());
//		this.setFuncionarios(endereco.getFuncionarios());
//		this.setEmpresasParceiras(endereco.getEmpresasParceiras());
//		this.setClientes(endereco.getClientes());
//		this.setCentrosDistribuicao(endereco.getCentrosDistribuicao());
		}

	public Endereco toEntity(EnderecoDTO enderecoDTO) {
    	Endereco endereco = new Endereco();
    	endereco.setCep(enderecoDTO.getCep());
    	endereco.setEstado(enderecoDTO.getEstado());
    	endereco.setCidade(enderecoDTO.getCidade());
    	endereco.setBairro(enderecoDTO.getBairro());
    	endereco.setLogradouro(enderecoDTO.getLogradouro());
    	endereco.setNumero(enderecoDTO.getNumero());
    	endereco.setComplemento(enderecoDTO.getComplemento());
//    	endereco.setAtivo(enderecoDTO.getAtivo());
//    	endereco.setFuncionarios(enderecoDTO.getFuncionarios());
//    	endereco.setEmpresasParceiras(enderecoDTO.getEmpresasParceiras());
//    	endereco.setClientes(enderecoDTO.getClientes());
//    	endereco.setCentrosDistribuicao(enderecoDTO.getCentrosDistribuicao());
    	return endereco;
    }
	
}