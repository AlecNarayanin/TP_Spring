package com.ynov.tp_spring.repositories;

import com.ynov.tp_spring.entities.User;
import com.ynov.tp_spring.entities.User_Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProjectRepository extends JpaRepository<User_Project, Long> {

    List<User> findParticipantByProject(Integer projectId);
    
}
