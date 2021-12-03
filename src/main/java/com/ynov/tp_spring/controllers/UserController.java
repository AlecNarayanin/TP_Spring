package com.ynov.tp_spring.controllers;

import com.ynov.tp_spring.dto.UserUpsertDTO;
import com.ynov.tp_spring.entities.User;
import com.ynov.tp_spring.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Récupération d'un utilisateur")
    @GetMapping(path = "/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @Operation(summary = "Récupération de tous les utilisateurs")
    @GetMapping(path = "/users/all")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @Valid
    @Operation(summary = "Création ou mise à jour d'un utilisateur")
    @PutMapping(path = "/user")
    public User upsertUser(@RequestBody UserUpsertDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setRole(userDTO.getRole());
        return userService.upsert(user);
    }

    @Operation(summary = "Suppression d'un utilisateur à partir de son identifiant")
    @DeleteMapping(path = "/user/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }
}
