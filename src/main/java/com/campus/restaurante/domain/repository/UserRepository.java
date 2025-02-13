package com.campus.restaurante.domain.repository;

import com.campus.restaurante.persistence.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    public Optional<Users> findByEmail(String email);
    public Optional<Users> findByName(String userName);
}
