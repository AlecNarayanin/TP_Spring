package com.ynov.tp_spring.repositories;

import com.ynov.tp_spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
