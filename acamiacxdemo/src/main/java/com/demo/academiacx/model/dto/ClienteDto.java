package com.demo.academiacx.model.dto;

import com.demo.academiacx.model.CarrinhoModel;
import com.demo.academiacx.model.ClienteModel;
import com.demo.academiacx.model.EnderecoModel;
import com.demo.academiacx.model.PrecoModel;
import jakarta.persistence.OneToMany;


import java.util.List;

public class ClienteDto {
    private String cpf;

    private String nome;

    private List<EnderecoModel> enderecos;

    private List<CarrinhoModel> carrinhos;

    private List<PrecoModel> precos;




    public ClienteDto() {
    }

    public ClienteDto(ClienteModel cliente) {
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
        this.enderecos = cliente.getEnderecos();
        this.carrinhos = cliente.getCarrinhos();
        this.enderecos = cliente.getEnderecos();
        this.precos = cliente.getPrecos();
        this.carrinhos = cliente.getCarrinhos();
    }

    public List<PrecoModel> getPrecos() {
        return precos;
    }

    public void setPrecos(List<PrecoModel> precos) {
        this.precos = precos;
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

    public List<EnderecoModel> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoModel> enderecos) {
        this.enderecos = enderecos;
    }

    public List<CarrinhoModel> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<CarrinhoModel> carrinhos) {
        this.carrinhos = carrinhos;
    }
}
