package com.br.apidesafioverzel.adapters.in.controllers;

import com.br.apidesafioverzel.application.dto.VeiculoDTO;
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
    public VeiculoDTO findById(@PathVariable Long id) {
        Vehicle veiculo = vehicleService.findById(id);
        return new VeiculoDTO(veiculo);
    }

    /*TODO: - Implementar a listagem de veiculos
            - Implementar a listagem de veiculos por marca
            - Implementar a listagem de veiculos por ano
            - Implementar a listagem de veiculos por preço
     */
    @PostMapping
    public void save(@RequestBody VeiculoDTO veiculoDTO) {
        Vehicle veiculo = new Vehicle();
        veiculo.setName(veiculoDTO.getName());
        veiculo.setBrand(veiculoDTO.getBrand());
        veiculo.setModel(veiculoDTO.getModel());
        veiculo.setDescription(veiculoDTO.getDescription());
        veiculo.setImgUrl(veiculoDTO.getImgUrl());
        veiculo.setYear(veiculoDTO.getYear());
        veiculo.setPrice(veiculoDTO.getPrice());
        vehicleService.save(veiculo);
    }
}
