package com.demo.academiacx.model;

import com.demo.academiacx.model.dto.ItemDto;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_item")
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private BigDecimal total;

    private  Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produto;

    @ManyToOne
    @JoinColumn(name = "preco_id")
    private PrecoModel preco;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private CarrinhoModel carrinho;


    public ItemModel(ItemDto itemDto) {
        this.total = itemDto.getTotal();
        this.quantidade = itemDto.getQuantidade();
        this.produto = itemDto.getProduto();
        this.preco = itemDto.getPreco();
        this.carrinho = itemDto.getCarrinho();
    }

    public ItemModel() {

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
}
