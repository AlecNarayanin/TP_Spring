package com.ynov.tp_spring.services;

import com.ynov.tp_spring.repositories.UserProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProjectService {

    @Autowired
    private UserProjectRepository userProjectRepository;
}
