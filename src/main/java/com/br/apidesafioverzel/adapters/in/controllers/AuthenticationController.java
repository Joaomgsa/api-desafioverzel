package com.br.apidesafioverzel.adapters.in.controllers;

import com.br.apidesafioverzel.application.services.AuthenticationSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationSevice authenticationSevice;

    public AuthenticationController(AuthenticationSevice authenticationSevice) {
        this.authenticationSevice = authenticationSevice;
    }

    @PostMapping("/authenticate")
    public String authenticate() {
        return authenticationSevice.authenticate();
    }
}
