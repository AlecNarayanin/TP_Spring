package com.ynov.tp_spring.services;

import com.ynov.tp_spring.entities.Comment;
import com.ynov.tp_spring.entities.Project;
import com.ynov.tp_spring.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment upsert(Comment comment) {
        return commentRepository.save(comment);
    }

    public void delete(Integer id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> getAllByProject(Integer projectId) {
        return commentRepository.findByProjectId(projectId);
    }


}
