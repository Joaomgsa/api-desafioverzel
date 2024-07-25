package com.br.apidesafioverzel.application.services;

import com.br.apidesafioverzel.adapters.out.repositories.BrandRepository;
import com.br.apidesafioverzel.application.dto.BrandDTO;
import com.br.apidesafioverzel.domain.entities.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// TODO: Implementar validações de negócio
@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDTO> findAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream().map(BrandDTO::new).collect(Collectors.toList());
    }

    public Brand findByName(String name) {
        return brandRepository.findByName(name);
    }

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand findById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        brandRepository.deleteById(id);
    }

    private void copyDTOToEntity(BrandDTO brandDTO, Brand brand) {
        brand.setName(brandDTO.getName());
    }
}
