package com.ynov.tp_spring.controllers;

import com.ynov.tp_spring.entities.Project;
import com.ynov.tp_spring.services.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(path = "/project", method = RequestMethod.GET)
    public Project getProject(@RequestParam(value = "id") Integer id) {
        return projectService.getById(id);
    }

    @Operation(summary = "Création ou mise à jour d'un projet")
    @RequestMapping(path = "/project", method = RequestMethod.PUT)
    public Project upsertProject(@RequestBody Project project) {
        projectService.upsert(project);
        return project;
    }

    @Operation(summary = "Suppression d'un projet")
    @RequestMapping(path = "/project", method = RequestMethod.DELETE)
    public String deleteProject(@RequestParam(value = "id") Integer id) {
        projectService.deleteById(id);
        return "project deleted !";
    }

    @Operation(summary = "Récupération de tous les projets")
    @RequestMapping(path = "/projects", method = RequestMethod.GET)
    public List<Project> getAllProjects() {
        return projectService.getAll();
    }

    @Operation(summary = "Acceptation d'une requête")
    @RequestMapping(path = "/project/request/accept", method = RequestMethod.PUT)
    public String acceptRequest(@RequestParam(value = "project_id") Integer projectId,
                                 @RequestParam(value = "request_id") Integer requestId) {
        return projectService.acceptRequest(requestId, projectId);
    }

    @Operation(summary = "Refus d'une requête")
    @RequestMapping(path = "/project/request/refuse", method = RequestMethod.PUT)
    public String refuseRequest(@RequestParam(value = "project_id") Integer projectId,
                                @RequestParam(value = "request_id") Integer requestId) {
        return projectService.refuseRequest(requestId, projectId);
    }

    @Operation(summary = "Suppression d'une requête")
    @RequestMapping(path = "/sortie/remove", method = RequestMethod.DELETE)
    public String removeRequest(@RequestParam(value = "project_id") Integer projectId,
                                @RequestParam(value = "request_id") Integer requestId) {
        return projectService.removeRequest(requestId, projectId);
    }

}
