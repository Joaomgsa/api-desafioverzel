package com.br.apidesafioverzel.application.services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationSevice {

    public String authenticate() {
        return "token";
    }
}
