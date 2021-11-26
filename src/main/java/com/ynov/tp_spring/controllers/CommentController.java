package com.ynov.tp_spring.controllers;


import com.ynov.tp_spring.entities.User;
import com.ynov.tp_spring.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;



    @PostMapping(path="user/{userId}/comment/{commentId}/likes")
    public ResponseEntity addlike(@PathVariable("userId") Integer userId,
                                  @PathVariable("commentId") Integer commentId) {
        try{
            commentService.addLike(commentId,userId);
            return new ResponseEntity(HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST );
        }
    }


    @DeleteMapping(path="user/{userId}/comment/{commentId}/likes")
    public ResponseEntity  removeLike(@PathVariable("userId") Integer userId, @PathVariable("commentId") Integer commentId){
        try{
            commentService.removeLike(commentId,userId);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "comment/{id}/likes")
    public List<User> getUserLikesCommentByCommentId(@PathVariable("id") Integer commentId){
        return commentService.getUsersWhoLikeComment(commentId);
    }

}

