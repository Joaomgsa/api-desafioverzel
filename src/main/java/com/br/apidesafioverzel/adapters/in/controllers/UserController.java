package com.br.apidesafioverzel.adapters.in.controllers;

import com.br.apidesafioverzel.application.dto.UserDTO;
import com.br.apidesafioverzel.application.services.RoleService;
import com.br.apidesafioverzel.application.services.UserService;
import com.br.apidesafioverzel.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleservice;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserController(UserService userService
            , RoleService roleservice
            , BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.roleservice = roleservice;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/me")
    public ResponseEntity<Boolean> isAdmin(JwtAuthenticationToken token) {
        var userauth = userService.findById(Long.parseLong(token.getToken().getSubject()));
        var isAdmin = userauth.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN"));
        return ResponseEntity.ok(isAdmin);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(JwtAuthenticationToken token) {
        var userauth = userService.findById(Long.parseLong(token.getToken().getSubject()));
        var isAdmin = userauth.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN"));

        if (!isAdmin) {
            return ResponseEntity.status(403).build();
        } else {
            return ResponseEntity.ok(userService.findAll());
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserDTO userDTO, JwtAuthenticationToken token) {

        var userauth = userService.findById(Long.parseLong(token.getToken().getSubject()));
        var isAdmin = userauth.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN"));

        if (!isAdmin) {
            return ResponseEntity.status(403).build();
        } else {
            var basicRole = roleservice.findByName("BASIC");
            User user = new User();
            user.setId(userDTO.getId());
            user.setUsername(userDTO.getUserName());
            user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
            user.setEmail(userDTO.getEmail());
            user.setBirthDate(userDTO.getBirthDate());
            user.setRoles(Set.of(basicRole));
            userService.save(user);
            return ResponseEntity.ok().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id, JwtAuthenticationToken token) {
        var userauth = userService.findById(Long.parseLong(token.getToken().getSubject()));
        var isAdmin = userauth.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN"));

        if (!isAdmin) {
            return ResponseEntity.status(403).build();
        } else {
            User user = userService.findById(id);
            return ResponseEntity.ok(new UserDTO(user));
        }
    }
}
