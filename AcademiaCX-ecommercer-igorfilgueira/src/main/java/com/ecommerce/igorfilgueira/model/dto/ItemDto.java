package com.ecommerce.igorfilgueira.model.dto;

import com.ecommerce.igorfilgueira.model.ItemModel;

public class ItemDto {
    private Long id;

    private int quantidade;

    private ProdutoDto produto;

    private CarrinhoDto carrinhoModel;

    public ItemDto() {
    }

    public ItemDto(ItemModel itemModel) {
        this.id = itemModel.getId();
        this.quantidade = itemModel.getQuantidade();
        this.produto = new ProdutoDto(itemModel.getProdutoModel());
        this.carrinhoModel = new CarrinhoDto(itemModel.getCarrinhoModel());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoDto getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDto produto) {
        this.produto = produto;
    }

    public CarrinhoDto getCarrinhoModel() {
        return carrinhoModel;
    }

    public void setCarrinhoModel(CarrinhoDto carrinhoModel) {
        this.carrinhoModel = carrinhoModel;
    }
}
