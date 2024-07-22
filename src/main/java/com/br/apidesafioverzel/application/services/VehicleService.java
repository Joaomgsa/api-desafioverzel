package com.br.apidesafioverzel.application.services;

import com.br.apidesafioverzel.adapters.out.repositories.VehicleRepository;
import com.br.apidesafioverzel.domain.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    //TODO: Implementar as validaçoes de regras de negocio

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle save(Vehicle veiculo) {
        return vehicleRepository.save(veiculo);
    }

    public Vehicle findByNome(String nome) {
        return vehicleRepository.findByName(nome);
    }

    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

    public void update(Vehicle veiculo) {
        vehicleRepository.save(veiculo);
    }

    public boolean existsByNome(String nome) {
        return vehicleRepository.existsByName(nome);
    }

}
