package com.academiacx.model.dto;

import com.academiacx.model.ClienteModel;

public class ClienteDto {

    private Long id;
    private String nome;
    private String cpf;


    public ClienteDto() {

    }

    public ClienteDto(ClienteModel clienteModel) {
        this.id = clienteModel.getId();
        this.nome = clienteModel.getNome();
        this.cpf = clienteModel.getCpf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
