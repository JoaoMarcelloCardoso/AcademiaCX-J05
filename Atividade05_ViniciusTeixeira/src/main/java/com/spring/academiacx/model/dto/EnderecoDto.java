package com.spring.academiacx.model.dto;

import com.spring.academiacx.model.EnderecoModel;
import com.spring.academiacx.model.UserModel;

public class EnderecoDto {

    private Long id;
    private int cep;
    private int numero;
    private String bairro;
    private String cidade;
    private String uf;

    private UserModel userModel;

    public EnderecoDto() {
    }

    public EnderecoDto(EnderecoModel enderecoModel) {
        this.id= enderecoModel.getId();
        this.cep = enderecoModel.getCep();
        this.numero = enderecoModel.getNumero();
        this.bairro = enderecoModel.getBairro();
        this.cidade = enderecoModel.getCidade();
        this.uf = enderecoModel.getUf();
        this.userModel = enderecoModel.getUserModel();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
