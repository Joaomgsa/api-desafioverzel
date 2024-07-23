package com.br.apidesafioverzel.domain.entities;


import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "tb_brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand")
    private Set<Car> cars;
    public Brand() {
    }

    public Brand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Car> getVehicles() {
        return cars;
    }

    public void setVehicles(Set<Car> cars) {
        this.cars = cars;
    }
}
