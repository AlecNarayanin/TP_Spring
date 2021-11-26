package com.ynov.tp_spring.controllers;

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
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public User getUser(@RequestParam(value = "id") Integer id) {
        return userService.getById(id);
    }

    @Operation(summary = "Récupération de tous les utilisateurs")
    @RequestMapping(path = "/users/all", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getAll();
    }

    //ROLE
    @Valid
    @Operation(summary = "Création ou mise à jour d'un utilisateur")
    @RequestMapping(path = "/user", method = RequestMethod.PUT)
    public User addOrUpdateUser(@RequestBody User user) {
        return userService.upsert(user);
    }

    //ROLE
    @Operation(summary = "Suppression d'un utilisateur à partir de son identifiant")
    @RequestMapping(path = "/user", method = RequestMethod.DELETE)
    public void delete(@RequestParam(value = "id") Integer id) {
        userService.delete(id);
    }
}
