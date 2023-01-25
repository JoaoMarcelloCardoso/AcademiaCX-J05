package com.cx.academy.exerciciontt.model.dto.response;

import com.cx.academy.exerciciontt.model.AddressModel;

import java.util.List;

public class ClientDtoResponse {

    private Long id;
    private String cpf;
    private String nome;
    private String username;
    private List<AddressModel> addresses;

    public ClientDtoResponse(Long id, String cpf, String nome, String username, List<AddressModel> addresses) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.username = username;
        this.addresses = addresses;
    }

    public ClientDtoResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<AddressModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressModel> addresses) {
        this.addresses = addresses;
    }
}
