package com.br.apidesafioverzel.application.services;

import com.br.apidesafioverzel.adapters.out.repositories.BrandRepository;
import com.br.apidesafioverzel.domain.entities.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Implementar validações de negócio
@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
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
}
