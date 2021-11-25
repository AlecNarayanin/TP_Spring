package com.ynov.tp_spring.controllers;

import com.ynov.tp_spring.services.UserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProjectController {

    @Autowired
    private UserProjectService userProjectService;
}
