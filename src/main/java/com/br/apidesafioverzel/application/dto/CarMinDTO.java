package com.br.apidesafioverzel.application.dto;

import com.br.apidesafioverzel.domain.entities.Car;

public class CarMinDTO {

    private Long id;
    private String name;
    private String brand;
    private String description;
    private String imgUrl;
    private Integer year;
    private Double price;

    public CarMinDTO(Long id, String name, String brand, String description, String imgUrl, Integer year, Double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.imgUrl = imgUrl;
        this.year = year;
        this.price = price;
    }

    public CarMinDTO(Car entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.brand = entity.getBrand().getName();
        this.description = entity.getDescription();
        this.imgUrl = entity.getImgUrl();
        this.year = entity.getYear();
        this.price = entity.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Integer getYear() {
        return year;
    }

    public Double getPrice() {
        return price;
    }
}
