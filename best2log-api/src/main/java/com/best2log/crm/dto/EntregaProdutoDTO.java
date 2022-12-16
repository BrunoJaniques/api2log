package com.best2log.crm.dto;

import java.time.LocalDateTime;

import com.best2log.crm.entity.StatusPedido;

public class EntregaProdutoDTO {

    private Integer idEntregaProduto;
    private Integer quantidade;
    private double valorLiquido;
    private StatusPedido status;
    private LocalDateTime dataArmazenamento;
    private String localizacaoEstoque;
    private ClienteDTO clienteDTO;
	
    public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}
	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}
	public Integer getIdEntregaProduto() {
		return idEntregaProduto;
	}
	public void setIdEntregaProduto(Integer idEntregaProduto) {
		this.idEntregaProduto = idEntregaProduto;
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
	public void setDataArmazenamento(LocalDateTime dataArmazenamento) {
		this.dataArmazenamento = dataArmazenamento;
	}
	public String getLocalizacaoEstoque() {
		return localizacaoEstoque;
	}
	public void setLocalizacaoEstoque(String localizacaoEstoque) {
		this.localizacaoEstoque = localizacaoEstoque;
	}
    
}
