package com.ynov.tp_spring.controllers;

import com.ynov.tp_spring.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @Autowired
    private RequestService requestService;
}
