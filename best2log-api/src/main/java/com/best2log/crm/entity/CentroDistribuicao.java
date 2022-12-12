package com.best2log.crm.entity;


import java.util.ArrayList;
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
@Table(name = "centro_distribuicao")
public class CentroDistribuicao {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_centro_distribuicao")
    private Integer idCentroDistribuicao;

    @Column(name = "nome_centro_distribuicao")
    private String nomeCentroDistribuicao;

    @Column(name = "bairrosAssociados")
    private ArrayList<String> bairrosAssociados;

    @Column(name = "ativo")
    private boolean ativo;
    
    @ManyToOne
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
    private Endereco endereco;
    
    @OneToMany(mappedBy = "centroDistribuicao")
	private Set<Estoque> estoques;
    
    @OneToMany(mappedBy = "centroDistribuicao")
	private Set<MapaDeCarga> mapasDeCarga;
    
//    @Column(name = "responsavel")
//    private Administrador responsavel;


	public Integer getIdCentroDistribuicao() {
		return idCentroDistribuicao;
	}

	public void setIdCentroDistribuicao(Integer idCentroDistribuicao) {
		this.idCentroDistribuicao = idCentroDistribuicao;
	}

	public String getNomeCentroDistribuicao() {
		return nomeCentroDistribuicao;
	}

	public void setNomeCentroDistribuicao(String nomeCentroDistribuicao) {
		this.nomeCentroDistribuicao = nomeCentroDistribuicao;
	}

	public ArrayList<String> getBairrosAssociados() {
		return bairrosAssociados;
	}

	public void setBairrosAssociados(ArrayList<String> bairrosAssociados) {
		this.bairrosAssociados = bairrosAssociados;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(Set<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Set<MapaDeCarga> getMapasDeCarga() {
		return mapasDeCarga;
	}

	public void setMapasDeCarga(Set<MapaDeCarga> mapasDeCarga) {
		this.mapasDeCarga = mapasDeCarga;
	}

	public void setAllAtributos(CentroDistribuicao centroDistribuicao) {
		this.setNomeCentroDistribuicao(centroDistribuicao.getNomeCentroDistribuicao());
		this.setEndereco(centroDistribuicao.getEndereco());
//        this.setResponsavel(centroDistribuicao.getResponsavel());
		this.setBairrosAssociados(centroDistribuicao.bairrosAssociados);
		this.setAtivo(centroDistribuicao.getAtivo());
		this.setEstoques(centroDistribuicao.getEstoques());
		this.setMapasDeCarga(centroDistribuicao.getMapasDeCarga());
	}

}

//OK