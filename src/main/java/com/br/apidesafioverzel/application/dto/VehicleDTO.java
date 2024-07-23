package com.br.apidesafioverzel.application.dto;

import com.br.apidesafioverzel.domain.entities.Brand;
import com.br.apidesafioverzel.domain.entities.Vehicle;

public class VehicleDTO {

    private Long id;
    private String name;
    private Brand brand;
    private String model;
    private String description;
    private String imgUrl;
    private Integer year;
    private Double price;

    public VehicleDTO(Long id, String name, Brand brand, String model, String description, String imgUrl, Integer year, Double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.imgUrl = imgUrl;
        this.year = year;
        this.price = price;
    }

    public VehicleDTO(Vehicle vehicle){
        this.id = vehicle.getId();
        this.name = vehicle.getName();
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.description = vehicle.getDescription();
        this.imgUrl = vehicle.getImgUrl();
        this.year = vehicle.getYear();
        this.price = vehicle.getPrice();
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
}
