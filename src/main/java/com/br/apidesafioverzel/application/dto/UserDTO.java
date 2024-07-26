package com.br.apidesafioverzel.application.dto;

import com.br.apidesafioverzel.domain.entities.User;

import java.time.LocalDate;

public class UserDTO {

    private Long id;
    private String userName;
    private String password;
    private String email;
    private LocalDate birthDate;

    public UserDTO(Long id, String userName,String password, String email, String phone, LocalDate birthDate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.userName = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.birthDate = user.getBirthDate();
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPassword() {
        return password;
    }
}
