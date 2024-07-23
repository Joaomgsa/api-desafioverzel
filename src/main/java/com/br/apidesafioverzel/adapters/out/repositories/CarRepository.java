package com.br.apidesafioverzel.adapters.out.repositories;

import com.br.apidesafioverzel.domain.entities.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long>
{
    Car findByName(String name);
    List<Car> findByYear(int year);
    boolean existsByName(String name);

    @Query("SELECT c FROM Car c WHERE UPPER(c.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Car> findByNameContaining(String name, Pageable pageable);

    @Query("SELECT c.id, c.name, b.name, c.description, c.imgUrl, c.year, c.price " +
            "FROM Car c JOIN c.brand b " +
            "ORDER BY c.year DESC")
    Page<Car> findAllOrderedByYear(Pageable pageable);
}
