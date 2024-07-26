package com.br.apidesafioverzel.application.services;

import com.br.apidesafioverzel.adapters.out.repositories.RoleRepository;
import com.br.apidesafioverzel.domain.entities.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
