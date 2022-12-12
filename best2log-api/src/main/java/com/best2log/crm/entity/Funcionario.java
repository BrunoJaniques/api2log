package com.best2log.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.best2log.crm.dto.FuncionarioDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id_funcionario")
	private Integer idFuncionario;

	@Column(name = "nome_funcionario")
	private String nomeFuncionario;

	@Column(name = "cpf_funcionario")
	private String cpfFuncionario;

	@Column(name = "rg_funcionario")
	private String rgFuncionario;

	@Column(name = "email_funcionario")
	private String emailFuncionario;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "senha_funcionario")
	private String senhaFuncionario;

	@Column(name = "funcao_funcionario")
	private TipoFuncionario funcaoFuncionario;

	@Column(name = "status_funcionario")
	private String statusFuncionario;

	@ManyToOne
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
	private Endereco endereco;

	public Funcionario() {
	}

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

	public String getStatusFuncionario() {
		return statusFuncionario;
	}

	public void setStatusFuncionario(String statusFuncionario) {
		this.statusFuncionario = statusFuncionario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setAllAtributos(Funcionario funcionario) {
		this.setNomeFuncionario(funcionario.getNomeFuncionario());
		this.setEndereco(funcionario.getEndereco());
		this.setCpfFuncionario(funcionario.getCpfFuncionario());
		this.setRgFuncionario(funcionario.getRgFuncionario());
		this.setEmailFuncionario(funcionario.getEmailFuncionario());
		this.setSenhaFuncionario(funcionario.getSenhaFuncionario());
		this.setFuncaoFuncionario(funcionario.getFuncaoFuncionario());
		this.setStatusFuncionario(funcionario.getStatusFuncionario());
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
		funcionario.setSenhaFuncionario(funcionarioDTO.getSenha());
//    	funcionario.setFuncao(funcionarioDTO.getFuncao());
		funcionario.setSenhaFuncionario(funcionarioDTO.getStatus());
		return funcionario;
	}

}
// OK
