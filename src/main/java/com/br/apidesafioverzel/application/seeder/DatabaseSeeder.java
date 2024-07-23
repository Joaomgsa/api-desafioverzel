package com.br.apidesafioverzel.application.seeder;

import com.br.apidesafioverzel.adapters.out.repositories.BrandRepository;
import com.br.apidesafioverzel.adapters.out.repositories.CarRepository;
import com.br.apidesafioverzel.adapters.out.repositories.UserRepository;
import com.br.apidesafioverzel.domain.entities.Brand;
import com.br.apidesafioverzel.domain.entities.Car;
import com.br.apidesafioverzel.domain.entities.User;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public DatabaseSeeder(UserRepository userRepository, CarRepository carRepository, BrandRepository brandRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        // Create and save users
        for (int i = 0; i < 7; i++) {
            java.util.Date date = faker.date().birthday();
            java.time.LocalDate localDate = date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            User user = new User(null, faker.name().firstName(), faker.internet().emailAddress(), faker.internet().password(),localDate);
            userRepository.save(user);
        }

        // Create and save brands
        Brand brand1 = new Brand(null, "Volks");
        brandRepository.save(brand1);

        // Create and save cars
        List<Brand> brands = brandRepository.findAll();
        for (int i = 0; i < 5; i++) {
            Brand brand = brands.get(faker.random().nextInt(brands.size()));
            Car car1 = new Car(null, "Uno", brand, "Teste de criação", faker.internet().image(), faker.number().numberBetween(1980, 2023), faker.number().randomDouble(2, 10000, 50000));
            carRepository.save(car1);
        }
    }
}