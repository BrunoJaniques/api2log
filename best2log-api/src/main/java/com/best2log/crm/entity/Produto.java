package com.best2log.crm.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id_produto;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nome_produto")
    private String nomeProduto;
    
    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "valor")
    private double valor;

    @Column(name = "ativo")
    private boolean ativo;
    
    @OneToMany(mappedBy = "produto")
	private Set<EntregaProduto> entregasProdutos;

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Set<EntregaProduto> getEntregasProdutos() {
		return entregasProdutos;
	}

	public void setEntregasProdutos(Set<EntregaProduto> entregasProdutos) {
		this.entregasProdutos = entregasProdutos;
	}

	public void setAllAtributos(Produto produto) {
        this.setCodigo(produto.getCodigo());
        this.setNomeProduto(produto.getNomeProduto());
        this.setCategoria(produto.getCategoria());
        this.setAtivo(produto.getAtivo());
        this.setValor(produto.getValor());
        this.setEntregasProdutos(produto.getEntregasProdutos());
    }

}