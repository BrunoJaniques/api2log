package com.best2log.crm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.best2log.crm.dto.FuncionarioDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Integer idFuncionario;
	
	@NotBlank(message = "Preencha o nome")
	@Column(name = "nome_funcionario", nullable = false)
	private String nomeFuncionario;

	@NotBlank(message = "Preencha o cpf")
	@Column(name = "cpf_funcionario", nullable = false)
	private String cpfFuncionario;

	@NotBlank(message = "Preencha o rg")
	@Column(name = "rg_funcionario", nullable = false)
	private String rgFuncionario;

	@NotBlank(message = "Preencha o email")
	@Column(name = "email_funcionario", nullable = false)
	private String emailFuncionario;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "senha_funcionario", nullable = false)
	private String senhaFuncionario;


	@Column(name = "funcao_funcionario", nullable = false)
	private TipoFuncionario funcaoFuncionario;

	@Column(name = "status_funcionario")
	private Status statusFuncionario;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
	private Endereco endereco;

	
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

	public String getCpfFuncionario() {
		return cpfFuncionario;
	}

	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}

	public String getRgFuncionario() {
		return rgFuncionario;
	}

	public void setRgFuncionario(String rgFuncionario) {
		this.rgFuncionario = rgFuncionario;
	}

	public String getEmailFuncionario() {
		return emailFuncionario;
	}

	public void setEmailFuncionario(String emailFuncionario) {
		this.emailFuncionario = emailFuncionario;
	}

	public String getSenhaFuncionario() {
		return senhaFuncionario;
	}

	public void setSenhaFuncionario(String senhaFuncionario) {
		this.senhaFuncionario = senhaFuncionario;
	}

	public TipoFuncionario getFuncaoFuncionario() {
		return funcaoFuncionario;
	}

	public void setFuncaoFuncionario(TipoFuncionario funcaoFuncionario) {
		this.funcaoFuncionario = funcaoFuncionario;
	}

	public Status getStatusFuncionario() {
		return statusFuncionario;
	}

	public void setStatusFuncionario(Status statusFuncionario) {
		this.statusFuncionario = statusFuncionario;
	}

	public void ativaStatus() {
		this.statusFuncionario = statusFuncionario.ATIVO;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
// OK
