package com.ynov.tp_spring.repositories;

import com.ynov.tp_spring.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {}
