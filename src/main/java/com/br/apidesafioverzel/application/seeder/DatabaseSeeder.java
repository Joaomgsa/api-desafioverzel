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

import java.util.Arrays;
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

        User meuUser = new User(null, "admin", faker.internet().emailAddress(), "admin", java.time.LocalDate.now());
        userRepository.save(meuUser);

        List<String> brandNames = Arrays.asList("Chevrolet", "Volkswagen", "Fiat", "Renault", "Ford", "Toyota", "Hyundai", "Jeep", "Honda", "Nissan");
        for (String brandName : brandNames) {
            Brand brand = new Brand();
            brand.setName(brandName);
            brandRepository.save(brand);
        }


        List<Brand> brands = brandRepository.findAll();
        for (int i = 0; i < 10; i++) {
            Brand brand = brands.get(faker.random().nextInt(brands.size()));
            Car car = new Car(null, "3008", brand, "Seminovo", "https://images.prd.kavak.io/eyJidWNrZXQiOiJrYXZhay1pbWFnZXMiLCJrZXkiOiJpbWFnZXMvMzM0NDY4L0VYVEVSSU9SLWZyb250U2lkZVBpbG90TmVhci0xNzIxNzU3NTM4MTk2LmpwZWciLCJlZGl0cyI6eyJyZXNpemUiOnsid2lkdGgiOjMxMiwiaGVpZ2h0IjoxOTJ9fX0=", faker.number().numberBetween(2010, 2023), faker.number().randomDouble(2, 10000, 50000));
            carRepository.save(car);
        }
    }
}