package com.br.apidesafioverzel.adapters.in.controllers;

import com.br.apidesafioverzel.application.dto.CarDTO;
import com.br.apidesafioverzel.application.dto.CarMinDTO;
import com.br.apidesafioverzel.application.services.CarService;
import com.br.apidesafioverzel.domain.entities.Car;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/carros")
public class CarController {

    @Autowired
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<Page<CarMinDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(carService.findAllOrderedByYear(pageable));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Page<CarDTO>> findAll(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            Pageable pageable) {
        return ResponseEntity.ok(carService.findAll(name, pageable));
    }


    @PostMapping
    public ResponseEntity<CarDTO> insert(@Valid @RequestBody CarDTO carDTO) {
        carDTO = carService.insert(carDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(carDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(carDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
