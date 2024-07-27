package com.br.apidesafioverzel.application.dto;

public class UserStatusDTO {
    private String username;
    private boolean isAdmin;

    public UserStatusDTO(String username, boolean isAdmin) {
        this.username = username;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}