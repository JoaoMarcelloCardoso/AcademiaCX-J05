package com.demo.academiacx.model;

import com.demo.academiacx.model.dto.EnderecoDto;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_endereco")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String cep;
    private String logradouro;
    private String numeroEndereco;
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String uf;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;


    public EnderecoModel(EnderecoDto enderecoDto) {
        this.cep = enderecoDto.getCep();
        this.logradouro = enderecoDto.getLogradouro();
        this.bairro = enderecoDto.getBairro();
        this.cidade = enderecoDto.getCidade();
        this.numeroEndereco = enderecoDto.getNumeroEndereco();
        this.uf = enderecoDto.getUf();
        this.cliente = new ClienteModel(enderecoDto.getCliente());
    }

    public EnderecoModel() {

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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
