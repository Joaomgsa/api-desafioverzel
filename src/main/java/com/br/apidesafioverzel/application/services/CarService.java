package com.br.apidesafioverzel.application.services;

import com.br.apidesafioverzel.adapters.out.repositories.BrandRepository;
import com.br.apidesafioverzel.adapters.out.repositories.CarRepository;
import com.br.apidesafioverzel.application.dto.CarDTO;
import com.br.apidesafioverzel.application.dto.CarMinDTO;
import com.br.apidesafioverzel.application.services.exceptions.DatabaseException;
import com.br.apidesafioverzel.application.services.exceptions.ResourceNotFoundException;
import com.br.apidesafioverzel.domain.entities.Brand;
import com.br.apidesafioverzel.domain.entities.Car;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
public class CarService {


    private final CarRepository carRepository;
    private final BrandRepository brandRepository;

    public CarService(CarRepository carRepository, BrandRepository brandRepository) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
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

    public CarMinDTO findById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new CarMinDTO(car);
    }

    @Transactional
    public CarDTO insert(CarDTO carDTO){
        Car car = new Car();
        Brand brand = carDTO.getBrand();
        if (brand != null) {
            // Save the brand before saving the car
            brand = brandRepository.save(brand);
            car.setBrand(brand);
        }
        copyDTOToEntity(carDTO, car);
        car = carRepository.save(car);
        return new CarDTO(car);
    }

    @Transactional
    public CarDTO update(Long id, CarDTO carDTO) {
        Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car not found"));
        Brand brand = carDTO.getBrand();
        if (brand.getId() == null) {
            brand = brandRepository.save(brand);
        }
        car.setName(carDTO.getName());
        car.setBrand(brand);
        car.setDescription(carDTO.getDescription());
        car.setImgUrl(carDTO.getImgUrl());
        car.setYear(carDTO.getYear());
        car.setPrice(carDTO.getPrice());
        car = carRepository.save(car);
        return new CarDTO(car);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            carRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha ao deletar o recurso");
        }

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
