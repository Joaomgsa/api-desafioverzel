package com.br.apidesafioverzel.adapters.out.repositories;

import com.br.apidesafioverzel.domain.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByName(String name);
    boolean existsByName(String name);
}
