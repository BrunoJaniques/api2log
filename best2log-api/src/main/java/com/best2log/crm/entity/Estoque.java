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
@Table(name = "estoque")
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estoque")
    private Integer idEstoque;

    @Column(name = "tipo")
    private TipoEstoque tipo;
    
    @Column(name = "nome_estoque")
    private String nomeEstoque;
    
	@Column(name = "vagas")
    private Integer vagas;
    
    @ManyToOne
    @JoinColumn(name = "id_centro_distribuicao", referencedColumnName = "id_centro_distribuicao")
    private CentroDistribuicao centroDistribuicao;

    @OneToMany(mappedBy = "estoque")
    private Set<EntregaProduto> entregasProdutos;
    
    public Integer getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    public CentroDistribuicao getCentroDistribuicao() {
        return centroDistribuicao;
    }

    public void setCentroDistribuicao(CentroDistribuicao centroDistribuicao) {
        this.centroDistribuicao = centroDistribuicao;
    }

    public TipoEstoque getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstoque tipo) {
        this.tipo = tipo;
    }

    public String getNomeEstoque() {
    	return nomeEstoque;
    }
    
    public void setNomeEstoque(String nomeEstoque) {
    	this.nomeEstoque = nomeEstoque;
    }
    
    public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	public Set<EntregaProduto> getEntregasProdutos() {
    	return entregasProdutos;
	}

	public void setEntregasProdutos(Set<EntregaProduto> entregasProdutos) {
		this.entregasProdutos = entregasProdutos;
	}

	public void setAllAtributos(Estoque estoque) {
        this.setCentroDistribuicao(estoque.getCentroDistribuicao());
        this.setTipo(estoque.getTipo());
        this.setNomeEstoque(estoque.getNomeEstoque());
        this.setVagas(estoque.getVagas());
        this.setNomeEstoque(estoque.getNomeEstoque());
        this.setEntregasProdutos(estoque.getEntregasProdutos());
    }
}