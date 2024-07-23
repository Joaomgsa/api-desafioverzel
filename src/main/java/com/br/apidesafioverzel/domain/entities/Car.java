package com.br.apidesafioverzel.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String description;
    private String imgUrl;
    private Integer year;
    private Double price;

    public Car() {
    }

    public Car(Long id, String name, String brand, String description, String imgUrl, Integer year, Double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.imgUrl = imgUrl;
        this.year = year;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
}
