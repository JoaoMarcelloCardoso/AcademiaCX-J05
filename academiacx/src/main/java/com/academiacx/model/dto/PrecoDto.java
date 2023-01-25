package com.academiacx.model.dto;

import com.academiacx.model.ClienteModel;
import com.academiacx.model.PrecoModel;
import com.academiacx.model.ProdutoModel;

import java.math.BigDecimal;


public class PrecoDto {

    private Long id;
    private BigDecimal valor;

    private ProdutoDto produto;

    private ClienteDto cliente;


    public PrecoDto() {

    }

    public PrecoDto(PrecoModel precoModel) {
        this.id = precoModel.getId();
        this.valor = precoModel.getValor();
        this.produto = new ProdutoDto(precoModel.getProduto());
        this.cliente = new ClienteDto(precoModel.getCliente());
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

    public ProdutoDto getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDto produto) {
        this.produto = produto;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }
}
