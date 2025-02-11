package com.campus.restaurante.domain.repository;

import com.campus.restaurante.persistence.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

}
