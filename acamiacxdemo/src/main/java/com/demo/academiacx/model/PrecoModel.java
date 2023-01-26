package com.demo.academiacx.model;

import com.demo.academiacx.model.dto.PrecoDto;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_preco")
public class PrecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produto;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;


    public PrecoModel(PrecoDto precoDto) {
        this.id = precoDto.getId();
        this.valor = precoDto.getValor();
        this.produto = precoDto.getProduto();
    }

    public PrecoModel() {

    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
