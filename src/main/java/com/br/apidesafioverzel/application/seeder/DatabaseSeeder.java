package com.br.apidesafioverzel.application.seeder;

import com.br.apidesafioverzel.adapters.out.repositories.BrandRepository;
import com.br.apidesafioverzel.adapters.out.repositories.CarRepository;
import com.br.apidesafioverzel.adapters.out.repositories.RoleRepository;
import com.br.apidesafioverzel.adapters.out.repositories.UserRepository;
import com.br.apidesafioverzel.domain.entities.Brand;
import com.br.apidesafioverzel.domain.entities.Car;
import com.br.apidesafioverzel.domain.entities.Role;
import com.br.apidesafioverzel.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final BrandRepository brandRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public DatabaseSeeder(UserRepository userRepository, CarRepository carRepository, BrandRepository brandRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Role adminRole = new Role(1L, "ADMIN");
        Role basicRole = new Role(2L, "BASIC");
        roleRepository.save(adminRole);
        roleRepository.save(basicRole);

        var role = roleRepository.findByName(Role.Values.BASIC.name());
        var roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name());
        var userAdmin = userRepository.findByUsername("admin");
        var date = java.time.LocalDate.now();

        userAdmin.ifPresentOrElse(
                user -> {
                    System.out.println("admin ja existe");
                },
                () -> {
                    var user = new User();
                    user.setUsername("admin");
                    user.setPassword(passwordEncoder.encode("123456"));
                    user.setBirthDate(date);
                    user.setEmail("admin@gmail.com");
                    user.setRoles(Set.of(roleAdmin));
                    userRepository.save(user);
                }
        );



        // Create and save users with hardcoded data
        List<User> users = Arrays.asList(
                new User(null, "John", "john@example.com", "password123", LocalDate.of(1990, 1, 1), Set.of(role)),
                new User(null, "Jane", "jane@example.com", "password123", LocalDate.of(1991, 2, 2), Set.of(role)),
                new User(null, "Jim", "jim@example.com", "password123", LocalDate.of(1992, 3, 3), Set.of(role)),
                new User(null, "Jill", "jill@example.com", "password123", LocalDate.of(1993, 4, 4), Set.of(role)),
                new User(null, "Jack", "jack@example.com", "password123", LocalDate.of(1994, 5, 5), Set.of(role)),
                new User(null, "Jenny", "jenny@example.com", "password123", LocalDate.of(1995, 6, 6), Set.of(role)),
                new User(null, "Joe", "joe@example.com", "password123", LocalDate.of(1996, 7, 7), Set.of(role))
        );

        userRepository.saveAll(users);

        List<String> brandNames = Arrays.asList("Chevrolet", "Volkswagen", "Fiat", "Renault", "Ford", "Toyota", "Hyundai", "Jeep", "Honda", "Nissan");
        for (String brandName : brandNames) {
            Brand brand = new Brand();
            brand.setName(brandName);
            brandRepository.save(brand);
        }

        List<Brand> brands = brandRepository.findAll();

        var img = "https://images.prd.kavak.io/eyJidWNrZXQiOiJrYXZhay1pbWFnZXMiLCJrZXkiOiJpbWFnZXMvMzM0NDY4L0VYVEVSSU9SLWZyb250U2lkZVBpbG90TmVhci0xNzIxNzU3NTM4MTk2LmpwZWciLCJlZGl0cyI6eyJyZXNpemUiOnsid2lkdGgiOjMxMiwiaGVpZ2h0IjoxOTJ9fX0=";
        // Create and save cars with hardcoded data
        List<Car> cars = Arrays.asList(
                new Car(null, "Model S", brands.get(0), "New", img, 2020, 80000.00),
                new Car(null, "Model 3", brands.get(1), "New", img, 2021, 35000.00),
                new Car(null, "Model X", brands.get(2), "New", img, 2022, 90000.00),
                new Car(null, "Model Y", brands.get(3), "New", img, 2023, 45000.00),
                new Car(null, "Civic", brands.get(4), "Used", img, 2019, 20000.00),
                new Car(null, "Accord", brands.get(5), "Used", img, 2018, 25000.00),
                new Car(null, "Corolla", brands.get(6), "Used", img, 2017, 18000.00),
                new Car(null, "Camry", brands.get(7), "Used", img, 2016, 22000.00),
                new Car(null, "Mustang", brands.get(8), "New", img, 2023, 55000.00)
        );

        carRepository.saveAll(cars);
    }
}