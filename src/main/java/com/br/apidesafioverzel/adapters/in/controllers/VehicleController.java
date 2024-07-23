package com.br.apidesafioverzel.adapters.in.controllers;

import com.br.apidesafioverzel.application.dto.VehicleDTO;
import com.br.apidesafioverzel.application.services.VehicleService;
import com.br.apidesafioverzel.domain.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/{id}")
    public VehicleDTO findById(@PathVariable Long id) {
        Vehicle veiculo = vehicleService.findById(id);
        return new VehicleDTO(veiculo);
    }

    /*TODO: - Implementar a listagem de veiculos
            - Implementar a listagem de veiculos por marca
            - Implementar a listagem de veiculos por ano
            - Implementar a listagem de veiculos por preço
     */
    @PostMapping
    public void save(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle veiculo = new Vehicle();
        veiculo.setName(vehicleDTO.getName());
        veiculo.setBrand(vehicleDTO.getBrand());
        veiculo.setModel(vehicleDTO.getModel());
        veiculo.setDescription(vehicleDTO.getDescription());
        veiculo.setImgUrl(vehicleDTO.getImgUrl());
        veiculo.setYear(vehicleDTO.getYear());
        veiculo.setPrice(vehicleDTO.getPrice());
        vehicleService.save(veiculo);
    }
}
