package com.demo.academiacx.model.dto;

import com.demo.academiacx.model.PrecoModel;
import com.demo.academiacx.model.ProdutoModel;


import java.math.BigDecimal;

public class PrecoDto {
    private Long id;

    private BigDecimal valor;

    private ProdutoModel produto;

    public PrecoDto() {
    }

    public PrecoDto(PrecoModel precoModel) {
        this.id = precoModel.getId();
        this.valor = precoModel.getValor();
        this.produto = precoModel.getProduto();
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
}
