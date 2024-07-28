package com.br.apidesafioverzel.application.dto;

import com.br.apidesafioverzel.domain.entities.Brand;
import com.br.apidesafioverzel.domain.entities.Car;
import jakarta.validation.constraints.*;

public class CarDTO {

    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    private String name;
    @NotBlank(message = "Marca é obrigatória")
    private Brand brand;
    private String description;
    private String imgUrl;
    @Positive(message = "Ano deve estar no formato YYYY e ser maior que zero")
    private Integer year;
    @Positive(message = "Preço deve ser maior que zero")
    private Double price;

    public CarDTO(Long id, String name, Brand brand, String description, String imgUrl, Integer year, Double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.imgUrl = imgUrl;
        this.year = year;
        this.price = price;
    }

    public CarDTO(Car car){
        this.id = car.getId();
        this.name = car.getName();
        this.brand = car.getBrand();
        this.description = car.getDescription();
        this.imgUrl = car.getImgUrl();
        this.year = car.getYear();
        this.price = car.getPrice();
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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
}
