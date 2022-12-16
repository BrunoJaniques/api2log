package com.best2log.crm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;
	
	@NotBlank(message = "Preencha o nome")
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@NotBlank(message = "Preencha o nome")
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "status")
	private Status status;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "cliente")
	private Set<EntregaProduto> entregasProdutos;

	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void ativaStatus() {
		this.status = status.ATIVO;
	}

	public Integer getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<EntregaProduto> getEntregasProdutos() {
		return entregasProdutos;
	}

	public void setEntregasProdutos(Set<EntregaProduto> entregasProdutos) {
		this.entregasProdutos = entregasProdutos;
	}
	
	public void setAllAtributos(Cliente cliente) {
		this.setNome(cliente.getNome());
		this.setCpf(cliente.getCpf());
		this.setEndereco(cliente.getEndereco());
//		this.setEntregasProdutos(cliente.getEntregasProdutos());
	}
	
}
