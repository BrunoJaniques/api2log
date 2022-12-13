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
@Table(name = "produto_estoque")
public class MapaDeCarga {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mapa_de_carga")
    private Integer idMapaDeCarga;

    @Column(name = "data")
    private LocalDateTime data;
    
    @Column(name = "status")
    private StatusPedido status;
    //Só pode: AGUARDANDO_CONFERENCIA, SEPARADO, EM_TRANSITO, ENTREGUE;

    @ManyToOne
    @JoinColumn(name = "id_centro_distribuicao", referencedColumnName = "id_centro_distribuicao")
    private CentroDistribuicao centroDistribuicao;
    
    @OneToMany(mappedBy = "mapaDeCarga")
	private Set<EntregaProduto> entregasProdutos;

//    @Column(name = "estoquista")
//    private Estoquista estoquista;
    
//    @Column(name = "motorista")
//    private Motorista motorista;
    
//    @Column(name = "administrador")
//    private Administrador administrador;
    
	public Integer getIdMapaDeCarga() {
		return idMapaDeCarga;
	}

	public void setIdMapaDeCarga(Integer idMapaDeCarga) {
		this.idMapaDeCarga = idMapaDeCarga;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public CentroDistribuicao getCentroDistribuicao() {
		return centroDistribuicao;
	}

	public void setCentroDistribuicao(CentroDistribuicao centroDistribuicao) {
		this.centroDistribuicao = centroDistribuicao;
	}

	public Set<EntregaProduto> getEntregasProdutos() {
		return entregasProdutos;
	}

	public void setEntregasProdutos(Set<EntregaProduto> entregasProdutos) {
		this.entregasProdutos = entregasProdutos;
	}
	
	public void setAllAtributos(MapaDeCarga mapaDeCarga) {
        this.setData(mapaDeCarga.getData());
        this.setStatus(mapaDeCarga.getStatus());
        this.setCentroDistribuicao(mapaDeCarga.getCentroDistribuicao());
        this.setEntregasProdutos(mapaDeCarga.getEntregasProdutos());
    }

}