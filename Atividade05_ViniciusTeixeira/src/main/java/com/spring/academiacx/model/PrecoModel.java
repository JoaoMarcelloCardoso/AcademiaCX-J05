package com.spring.academiacx.model;


import com.spring.academiacx.model.dto.PrecoDto;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_preco")
public class PrecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float valor;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produtoModel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel userModel;

    public PrecoModel(PrecoDto PrecoDto) {
        this.id= PrecoDto.getId();
        this.valor= PrecoDto.getValor();
        this.produtoModel = PrecoDto.getProdutoModel();
        this.userModel = PrecoDto.getUserModel();
    }

    public PrecoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public ProdutoModel getProdutoModel() {
        return produtoModel;
    }

    public void setProdutoModel(ProdutoModel produtoModel) {
        this.produtoModel = produtoModel;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
