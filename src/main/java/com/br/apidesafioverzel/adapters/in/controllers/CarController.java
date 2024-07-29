package com.br.apidesafioverzel.adapters.in.controllers;

import com.br.apidesafioverzel.application.dto.CarDTO;
import com.br.apidesafioverzel.application.dto.CarMinDTO;
import com.br.apidesafioverzel.application.services.CarService;
import com.br.apidesafioverzel.application.services.UserService;
import com.br.apidesafioverzel.domain.entities.Car;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/carros")
public class CarController {


    private CarService carService;
    private UserService userService;

    public CarController(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<CarMinDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(carService.findAllOrderedByYear(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarMinDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Page<CarDTO>> findAll(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            Pageable pageable) {
        return ResponseEntity.ok(carService.findAll(name, pageable));
    }


    @PostMapping
    public ResponseEntity<CarDTO> insert(@Valid @RequestBody CarDTO carDTO, JwtAuthenticationToken token) {

        var user = userService.findById(Long.parseLong(token.getToken().getSubject()));
        var isAdmin = user.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN"));
        System.out.println("##### EH ADMIN:  "+isAdmin+"###########");


        if (!isAdmin) {
            return ResponseEntity.status(403).build();
        } else {
            carDTO = carService.insert(carDTO);
             URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(carDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(carDTO);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> update(@PathVariable Long id, @Valid @RequestBody CarDTO carDTO, JwtAuthenticationToken token) {
        var user = userService.findById(Long.parseLong(token.getToken().getSubject()));
        var isAdmin = user.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN"));

        if (!isAdmin) {
            return ResponseEntity.status(403).build();
        } else {
            carDTO = carService.update(id, carDTO);
            return ResponseEntity.ok(carDTO);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, JwtAuthenticationToken token) {
        var user = userService.findById(Long.parseLong(token.getToken().getSubject()));
        var isAdmin = user.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN"));

        if (!isAdmin) {
            return ResponseEntity.status(403).build();
        } else {
            carService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }


}
