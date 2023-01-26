package com.demo.academiacx.model.dto;

import com.demo.academiacx.model.ClienteModel;
import com.demo.academiacx.model.EnderecoModel;

public class EnderecoDto {
    private Long id;
    private String cep;
    private String logradouro;
    private String numeroEndereco;
    private String bairro;
    private String cidade;
    private String uf;
    private ClienteDto cliente;

    public EnderecoDto() {
    }

    public EnderecoDto(EnderecoModel enderecoModel) {
        this.cep = enderecoModel.getCep();
        this.logradouro = enderecoModel.getLogradouro();
        this.bairro = enderecoModel.getBairro();
        this.cidade = enderecoModel.getCidade();
        this.numeroEndereco = enderecoModel.getNumeroEndereco();
        this.uf = enderecoModel.getUf();
        this.cliente = new ClienteDto(enderecoModel.getCliente());
    }


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
