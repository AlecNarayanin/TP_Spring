package com.ynov.tp_spring.controllers;

import com.ynov.tp_spring.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikesController {

    @Autowired
    private LikesService likesService;

}
