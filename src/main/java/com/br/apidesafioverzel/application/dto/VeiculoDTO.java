package com.br.apidesafioverzel.application.dto;

import com.br.apidesafioverzel.domain.entities.Veiculo;

public class VeiculoDTO {

    public Long id;
    public String nome;
    public String marca;
    public String foto;
    public String ano;
    public Double preco;


    public VeiculoDTO(Long id, String nome, String marca, String foto, String ano, Double preco) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.foto = foto;
        this.ano = ano;
        this.preco = preco;
    }

    public VeiculoDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.nome = veiculo.getNome();
        this.marca = veiculo.getMarca();
        this.foto = veiculo.getFoto();
        this.ano = veiculo.getAno();
        this.preco = veiculo.getPreco();
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
