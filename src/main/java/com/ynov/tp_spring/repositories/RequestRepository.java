package com.ynov.tp_spring.repositories;

import com.ynov.tp_spring.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Integer> {

    //List<Request> findByProjectId(Integer projectId);
}
