package com.br.apidesafioverzel.adapters.in.controllers;

import com.br.apidesafioverzel.application.dto.BrandDTO;
import com.br.apidesafioverzel.application.services.BrandService;
import com.br.apidesafioverzel.domain.entities.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// TODO: Implementar validações de negócio e de request
@RestController
@RequestMapping("/brands")
public class BrandController {


    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<List<BrandDTO>> findAll() {
         List<BrandDTO> brands = brandService.findAll();
         return ResponseEntity.ok(brands);
    }

    @GetMapping("/{name}")
    public BrandDTO findByName(@PathVariable String name) {
        Brand brand = brandService.findByName(name);
        return new BrandDTO(brand);
    }

    @PostMapping
    public void save(@RequestBody BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setName(brandDTO.getName());
        brandService.save(brand);
    }

    @PatchMapping
    public void update(@RequestBody BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setName(brandDTO.getName());
        brandService.save(brand);
    }


}
