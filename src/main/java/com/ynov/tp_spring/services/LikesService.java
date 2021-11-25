package com.ynov.tp_spring.services;

import com.ynov.tp_spring.repositories.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesService {

    @Autowired
    private LikesRepository likesRepository;

}
