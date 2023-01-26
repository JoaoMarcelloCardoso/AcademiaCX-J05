package com.academiacx.models.dto;

import com.academiacx.models.ClienteModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteDto {
    private String cpf;
    private String nome;

    @JsonProperty
    (access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClienteDto(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public ClienteDto() {
    }

    public ClienteDto(ClienteModel clienteModel) {
        this.cpf = clienteModel.getCpf();
        this.nome = clienteModel.getNome();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
