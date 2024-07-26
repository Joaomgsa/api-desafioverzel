package com.br.apidesafioverzel.adapters.out.repositories;

import com.br.apidesafioverzel.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>
{
    Role findByName(String name);
}
