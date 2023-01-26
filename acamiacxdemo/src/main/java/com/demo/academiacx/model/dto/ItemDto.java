package com.demo.academiacx.model.dto;

import com.demo.academiacx.model.CarrinhoModel;
import com.demo.academiacx.model.ItemModel;
import com.demo.academiacx.model.PrecoModel;
import com.demo.academiacx.model.ProdutoModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class ItemDto {
    private Long id;

    private BigDecimal total;

    private  Integer quantidade;

    private ProdutoModel produto;

    private PrecoModel preco;


    private CarrinhoModel carrinho;


    public ItemDto() {
    }

    public ItemDto(ItemModel itemModel) {
        this.id = itemModel.getId();
        this.total = itemModel.getTotal();
        this.quantidade = itemModel.getQuantidade();
        this.produto = itemModel.getProduto();
        this.preco = itemModel.getPreco();
        this.carrinho = itemModel.getCarrinho();
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public PrecoModel getPreco() {
        return preco;
    }

    public void setPreco(PrecoModel preco) {
        this.preco = preco;
    }

    public CarrinhoModel getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoModel carrinho) {
        this.carrinho = carrinho;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
