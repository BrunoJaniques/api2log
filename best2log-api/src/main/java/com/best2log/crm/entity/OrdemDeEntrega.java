package com.best2log.crm.entity;

import java.time.LocalDateTime;
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
@Table(name = "ordem_de_entrega")
public class OrdemDeEntrega {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ordem_de_entrega")
    private Integer idOrdemDeEntrega;

    @Column(name = "data")
    private LocalDateTime data;

    @Column(name = "data_conferencia")
    private LocalDateTime dataConferencia;

    @ManyToOne
    @JoinColumn(name = "remetente", referencedColumnName = "id_empresa_parceira")
    private EmpresaParceira remetente;
    
    @OneToMany(mappedBy = "ordemDeEntrega")
	private Set<EntregaProduto> entregasProdutos;
    
//    @ManyToOne
//	@JoinColumn(name = "remetente")
//    private Administrador administrador;
//	Como fazer os relacionamentos utilizando as herancas? 
    
	public Integer getIdOrdemDeEntrega() {
		return idOrdemDeEntrega;
	}

	public void setIdOrdemDeEntrega(Integer idOrdemDeEntrega) {
		this.idOrdemDeEntrega = idOrdemDeEntrega;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public LocalDateTime getDataConferencia() {
		return dataConferencia;
	}

	public void setDataConferencia(LocalDateTime dataConferencia) {
		this.dataConferencia = dataConferencia;
	}

	public EmpresaParceira getRemetente() {
		return remetente;
	}

	public void setRemetente(EmpresaParceira remetente) {
		this.remetente = remetente;
	}

	public Set<EntregaProduto> getEntregasProdutos() {
		return entregasProdutos;
	}

	public void setEntregasProdutos(Set<EntregaProduto> entregasProdutos) {
		this.entregasProdutos = entregasProdutos;
	}
	
	public void setAllAtributos(OrdemDeEntrega ordemDeEntrega) {
	    this.setRemetente(ordemDeEntrega.getRemetente());
	    this.setData(ordemDeEntrega.getData());
	    this.setEntregasProdutos(ordemDeEntrega.getEntregasProdutos());
	    this.setDataConferencia(ordemDeEntrega.getDataConferencia());
	}



}