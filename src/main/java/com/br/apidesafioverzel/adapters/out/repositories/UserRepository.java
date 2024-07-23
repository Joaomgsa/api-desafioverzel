package com.br.apidesafioverzel.adapters.out.repositories;

import com.br.apidesafioverzel.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    <Optional>User findByUsername(String username);

    boolean existsByEmail(String email);
}
