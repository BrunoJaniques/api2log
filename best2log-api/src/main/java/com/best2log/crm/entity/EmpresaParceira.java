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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empresa_parceira")
public class EmpresaParceira {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa_parceira")
    private Integer idEmpresaParceira;

    @Column(name = "nome_empresa_parceira", nullable = false)
    private String nomeEmpresaParceira;

    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "status")
    private Status status;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
    private Endereco endereco;
    
    @OneToMany(mappedBy = "remetente")
	private Set<OrdemDeEntrega> ordensDeEntrega;

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
	
	public void ativaStatus() {
		this.status = status.ATIVO; 
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<OrdemDeEntrega> getOrdensDeEntrega() {
		return ordensDeEntrega;
	}

	public void setOrdensDeEntrega(Set<OrdemDeEntrega> ordensDeEntrega) {
		this.ordensDeEntrega = ordensDeEntrega;
	}
	
}