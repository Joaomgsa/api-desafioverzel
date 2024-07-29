package com.br.apidesafioverzel.application.dto;

import com.br.apidesafioverzel.domain.entities.Brand;
import jakarta.validation.constraints.NotBlank;

public class BrandDTO {

    private Long id;
    @NotBlank(message = "Nome da marca é obrigatório")
    private String name;

    public BrandDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public BrandDTO(Brand brand){
        this.id = brand.getId();
        this.name = brand.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
