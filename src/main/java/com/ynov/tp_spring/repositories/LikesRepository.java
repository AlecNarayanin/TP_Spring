package com.ynov.tp_spring.repositories;

import com.ynov.tp_spring.entities.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes,Integer> { }
