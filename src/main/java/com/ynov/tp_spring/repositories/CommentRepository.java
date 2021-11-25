package com.ynov.tp_spring.repositories;

import com.ynov.tp_spring.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByProjectId(Integer projectId);

}
