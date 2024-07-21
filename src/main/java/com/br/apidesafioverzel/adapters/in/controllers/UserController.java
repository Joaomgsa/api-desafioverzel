package com.br.apidesafioverzel.adapters.in.controllers;

import com.br.apidesafioverzel.application.dto.UserDTO;
import com.br.apidesafioverzel.application.services.UserService;
import com.br.apidesafioverzel.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void save(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setBirthDate(userDTO.getBirthDate());
        userService.save(user);
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return new UserDTO(user);
    }
}
