package com.br.apidesafioverzel.application.dto;

import com.br.apidesafioverzel.domain.entities.User;

import java.time.LocalDate;

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;

    public UserDTO(Long id, String name, String email, String phone, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.birthDate = user.getBirthDate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

}
