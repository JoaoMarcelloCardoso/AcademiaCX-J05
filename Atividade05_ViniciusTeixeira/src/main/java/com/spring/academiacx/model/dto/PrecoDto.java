package com.spring.academiacx.model.dto;

import com.spring.academiacx.model.PrecoModel;
import com.spring.academiacx.model.UserModel;
import com.spring.academiacx.model.ProdutoModel;

public class PrecoDto {

    private Long id;
    private float valor;

    private ProdutoModel produtoModel;

    private UserModel userModel;

    public PrecoDto() {
    }

    public PrecoDto(PrecoModel precoModel) {
        this.id= precoModel.getId();
        this.valor = precoModel.getValor();
        this.produtoModel = precoModel.getProdutoModel();
        this.userModel = precoModel.getUserModel();
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
