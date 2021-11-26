package com.ynov.tp_spring.controllers;

import com.ynov.tp_spring.dto.ProjectUpsertDTO;
import com.ynov.tp_spring.entities.Project;
import com.ynov.tp_spring.entities.User;
import com.ynov.tp_spring.services.ProjectService;
import com.ynov.tp_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;


    @GetMapping(path = "/project/{id}")
    public Project getProjectById(Integer id){
        return projectService.getProjectById(id);
    }

    @PutMapping(path = "/project/")
    public Project upsertProject(@RequestBody ProjectUpsertDTO projectDTO){

        Project project = projectDTO.getId() == null ?
                new Project().mapUpsertDto(projectDTO) : projectService.getProjectById(projectDTO.getId()).mapUpsertDto(projectDTO);

        User usr = userService.getById(projectDTO.getAuteurId());
        if(usr != null) project.setAuteur(usr);

        return projectService.upsert(project);
    }

    @DeleteMapping(path = "/project/{id}")
    public void deleteProjectById(Integer id){
         projectService.deleteProjectById(id);
    }


}
