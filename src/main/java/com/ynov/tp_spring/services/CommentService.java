package com.ynov.tp_spring.services;

import com.ynov.tp_spring.entities.Comment;
import com.ynov.tp_spring.entities.User;
import com.ynov.tp_spring.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserService userService;

    public Comment upsert(Comment comment) {
        return commentRepository.save(comment);
    }

    public void delete(Integer id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> getAllByProject(Integer projectId) {
        return commentRepository.findByProjectId(projectId);
    }

    public Comment getById(Integer id) {
        return commentRepository.getById(id);
    }

    public void addLike(Integer commentId , Integer userId){
        Comment comment = this.getById(commentId);
        if(comment != null){
            User user = userService.getById(userId);
            if(user!=null){
               commentRepository.save(comment.addUser(user));
            }
        }
    }

    public void removeLike(Integer commentId , Integer userId){
        Comment comment = this.getById(commentId);
        if(comment != null){
            commentRepository.save(comment.removeUserById(userId));
        }
    }

    public List<User> getUsersWhoLikeComment(Integer commentId){
        Comment comment = this.getById(commentId);
        return comment != null ? comment.getUsers() : new ArrayList<User>();
    }
}
