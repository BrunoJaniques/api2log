package com.best2log.crm.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cpf")
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "cliente")
	private Set<EntregaProduto> entregasProdutos;

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
		this.setEntregasProdutos(cliente.getEntregasProdutos());
	}
	
}
