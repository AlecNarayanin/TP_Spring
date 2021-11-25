package com.ynov.tp_spring.repositories;

import com.ynov.tp_spring.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Integer> { }
