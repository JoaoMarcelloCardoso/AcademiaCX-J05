package com.spring.academiacx.model;


import com.spring.academiacx.model.dto.ItemDto;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_item")
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    private float total;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produtoModel;

    @ManyToOne
    @JoinColumn(name = "preco_id")
    private PrecoModel precoModel;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private CarrinhoModel carrinhoModel;

    public ItemModel(ItemDto itemDto) {
        this.id= itemDto.getId();
        this.quantidade= itemDto.getQuantidade();
        this.total = itemDto.getTotal();
        this.produtoModel = itemDto.getProdutoModel();
        this.precoModel = itemDto.getPrecoModel();
        this.carrinhoModel = itemDto.getCarrinhoModel();
    }

    public ItemModel() {

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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ProdutoModel getProdutoModel() {
        return produtoModel;
    }

    public void setProdutoModel(ProdutoModel produtoModel) {
        this.produtoModel = produtoModel;
    }

    public PrecoModel getPrecoModel() {
        return precoModel;
    }

    public void setPrecoModel(PrecoModel precoModel) {
        this.precoModel = precoModel;
    }

    public CarrinhoModel getCarrinhoModel() {
        return carrinhoModel;
    }

    public void setCarrinhoModel(CarrinhoModel carrinhoModel) {
        this.carrinhoModel = carrinhoModel;
    }
}
