package com.br.apidesafioverzel.domain.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    private String description;
    private String imgUrl;
    private Integer year;
    private Double price;

    private Brand brand;

    public Vehicle() {
    }

    public Vehicle(Long id, String name, String model, String description, String imgUrl, Integer year, Double price, Brand brand) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.description = description;
        this.imgUrl = imgUrl;
        this.year = year;
        this.price = price;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
