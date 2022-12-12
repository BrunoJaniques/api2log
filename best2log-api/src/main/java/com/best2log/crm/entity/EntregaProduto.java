package com.best2log.crm.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrega_produto")
public class EntregaProduto {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega_produto")
    private Integer idEntregaProduto;
    
    @ManyToOne
	@JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private Produto produto;
    
    @Column(name = "quantidade")
    private Integer quantidade;
    
    @Column(name = "valor_liquido")
    private double valorLiquido;
    
    @Column(name = "status")
    private StatusPedido status;
    
    @Column(name = "data_armazenamento")
    private LocalDateTime dataArmazenamento;
    
    @Column(name = "localizacao_estoque")
    private String localizacaoEstoque;
    
    @ManyToOne
	@JoinColumn(name = "id_ordem_de_entrega", referencedColumnName = "id_ordem_de_entrega")
    private OrdemDeEntrega ordemDeEntrega;
    
    @ManyToOne
	@JoinColumn(name = "id_mapa_de_carga", referencedColumnName = "id_mapa_de_carga")
    private MapaDeCarga mapaDeCarga;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;
    
    @ManyToOne
	@JoinColumn(name = "id_estoque", referencedColumnName = "id_estoque")
    private Estoque estoque;
    
//    @Column(name = "estoquista")
//    private Estoquista estoquista;
    
//    @Column(name = "conferente")
//    private Conferente conferente;
    
	public Integer getIdEntregaProduto() {
		return idEntregaProduto;
	}

	public void setIdEntregaProduto(Integer idEntregaProduto) {
		this.idEntregaProduto = idEntregaProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public LocalDateTime getDataArmazenamento() {
		return dataArmazenamento;
	}

	public void setDataArmazenamento(LocalDateTime dataArmazenament) {
		this.dataArmazenamento = dataArmazenament;
	}

	public String getLocalizacaoEstoque() {
		return localizacaoEstoque;
	}

	public void setLocalizacaoEstoque(String localizacaoEstoque) {
		this.localizacaoEstoque = localizacaoEstoque;
	}

	public OrdemDeEntrega getOrdemDeEntrega() {
		return ordemDeEntrega;
	}

	public void setOrdemDeEntrega(OrdemDeEntrega ordemDeEntrega) {
		this.ordemDeEntrega = ordemDeEntrega;
	}

	public MapaDeCarga getMapaDeCarga() {
		return mapaDeCarga;
	}

	public void setMapaDeCarga(MapaDeCarga mapaDeCarga) {
		this.mapaDeCarga = mapaDeCarga;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	public void setAllAtributos(EntregaProduto entregaProduto) {
        this.setQuantidade(entregaProduto.getQuantidade());
        this.setOrdemDeEntrega(entregaProduto.getOrdemDeEntrega());
        this.setProduto(entregaProduto.getProduto());
        this.setValorLiquido(entregaProduto.getValorLiquido());
        this.setDataArmazenamento(entregaProduto.getDataArmazenamento());
        this.setStatus(entregaProduto.getStatus());
        this.setLocalizacaoEstoque(entregaProduto.getLocalizacaoEstoque());
        this.setMapaDeCarga(entregaProduto.getMapaDeCarga());
        this.setCliente(entregaProduto.getCliente());
        this.setEstoque(entregaProduto.getEstoque());
    }

}