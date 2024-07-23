package com.br.apidesafioverzel.application.services;

import com.br.apidesafioverzel.adapters.out.repositories.CarRepository;
import com.br.apidesafioverzel.application.dto.CarDTO;
import com.br.apidesafioverzel.application.dto.CarMinDTO;
import com.br.apidesafioverzel.domain.entities.Car;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // TODO: Implementar as exceções de regras de negócio
    @Transactional
    public Page<CarDTO> findAll(String name, Pageable pageable) {
        Page<Car> result = carRepository.findByNameContaining(name, pageable);
        return result.map(CarDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<CarMinDTO> findAllOrderedByYear(Pageable pageable) {
        Page<Car> result = carRepository.findAll(pageable);
        return result.map(x-> new CarMinDTO(x));
    }

    @Transactional
    public CarDTO insert(CarDTO carDTO){
        Car car = new Car();
        copyDTOToEntity(carDTO, car);
        car = carRepository.save(car);
        return new CarDTO(car);
    }

    @Transactional
    public void delete(Long id) {
        carRepository.deleteById(id);
    }


    private void copyDTOToEntity(CarDTO carDTO, Car car){
        car.setId(carDTO.getId());
        car.setName(carDTO.getName());
        car.setBrand(carDTO.getBrand());
        car.setDescription(carDTO.getDescription());
        car.setImgUrl(carDTO.getImgUrl());
        car.setYear(carDTO.getYear());
        car.setPrice(carDTO.getPrice());
    }
}
