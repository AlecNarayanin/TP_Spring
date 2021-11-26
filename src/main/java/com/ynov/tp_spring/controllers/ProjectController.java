package com.ynov.tp_spring.controllers;

import com.ynov.tp_spring.dto.ProjectUpsertDTO;
import com.ynov.tp_spring.entities.Project;
import com.ynov.tp_spring.entities.User;
import com.ynov.tp_spring.services.ProjectService;
import com.ynov.tp_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;


    @GetMapping(path = "/project/{id}")
    public Project getProjectById( @PathVariable("id") Integer id){
        return projectService.getProjectById(id);
    }

    @GetMapping(path = "/projects")
    public List<Project> getAllProjects() {
        return projectService.getAll();
    }

    @PutMapping(path = "/project/")
    public Integer upsertProject(@RequestBody ProjectUpsertDTO projectDTO){

        Project project = projectDTO.getId() == null ?
                new Project().mapUpsertDto(projectDTO) : projectService.getProjectById(projectDTO.getId()).mapUpsertDto(projectDTO);

        User user = userService.getById(projectDTO.getAuteurId());
        if(user != null) project.setAuteur(user);

        return projectService.upsert(project).getId();
    }

    @DeleteMapping(path = "/project/{id}")
    public String deleteProjectById(@PathVariable("id") Integer id){
         projectService.deleteProjectById(id);
         return "project has been deleted";
    }

    @PutMapping(path = "/project/{projectId}/request/{requestId}/accept")
    public String acceptRequest(@PathVariable("projectId") Integer projectId,
                                @PathVariable("requestId") Integer requestId) {
        return projectService.acceptRequest(requestId, projectId);
    }

    @PutMapping(path = "/project/{projectId}/request/{requestId}/refuse")
    public String refuseRequest(@PathVariable("projectId") Integer projectId,
                                @PathVariable("requestId") Integer requestId) {
        return projectService.refuseRequest(requestId);
    }

    @DeleteMapping(path = "/project/{projectId}/request/{requestId}")
    public String removeRequest(@PathVariable("projectId") Integer projectId,
                                @PathVariable("requestId") Integer requestId){
        return projectService.removeRequest(requestId, projectId);
    }


}
