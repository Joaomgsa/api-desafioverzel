package com.br.apidesafioverzel.application.services;


import com.br.apidesafioverzel.adapters.out.repositories.BrandRepository;
import com.br.apidesafioverzel.application.dto.BrandDTO;
import com.br.apidesafioverzel.domain.entities.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


    //TODO : Implementar o tratamento de exceções
@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Transactional
    public List<BrandDTO> findByName(String name){
        List<Brand> brands = new ArrayList<>();
        List<BrandDTO> brandDTOs = new ArrayList<>();
        for (Brand brand : brandRepository.findByNameContaining(name)) {
            brands.add(brand);
            brandDTOs.add(new BrandDTO(brand));
        }
        return brandDTOs;
    }

    private void copyDTOToEntity(BrandDTO brandDTO, Brand brand){
        brand.setId(brandDTO.getId());
        brand.setName(brandDTO.getName());
    }
}
