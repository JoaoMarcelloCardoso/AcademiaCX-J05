package com.academiacx.model;

import com.academiacx.model.dto.PrecoDto;
import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "tb_preco")
public class PrecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutoModel produto;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;


    public PrecoModel() {

    }

    public PrecoModel(PrecoDto precoDto) {
        this.id = precoDto.getId();
        this.valor = precoDto.getValor();
        this.produto = new ProdutoModel(precoDto.getProduto());
        this.cliente = new ClienteModel(precoDto.getCliente());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
