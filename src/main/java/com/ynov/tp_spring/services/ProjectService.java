package com.ynov.tp_spring.services;

import com.ynov.tp_spring.entities.Project;
import com.ynov.tp_spring.entities.Request;
import com.ynov.tp_spring.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RequestService requestService;


    public Project upsert(Project p){
        return projectRepository.save(p);
    }

    public Project getProjectById(Integer id){
        return  projectRepository.getById(id);
    }
    public void deleteProjectById(Integer id ){
        if(projectRepository.existsById(id)){
            projectRepository.deleteById(id);
        }
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public String acceptRequest(Integer requestId, Integer projectId) {
        Request request = requestService.getById(requestId);
        Project project = getProjectById(projectId);

        boolean success = project.addRequest(request);
        if (success) {
            requestService.handleRequestStatus(requestId, Request.RequestStatus.ACCEPTED);
            upsert(project);
            return "request has been submitted to project";
        }

        return "error during request submission to project";
    }

    public String refuseRequest(Integer requestId) {
        requestService.handleRequestStatus(requestId, Request.RequestStatus.DECLINED);
        return "request has been successfully declined";
    }

    public String removeRequest(Integer requestId, Integer projectId) {
        Project project = getProjectById(projectId);

        boolean success = project.deleteRequest(requestId);
        if (success) {
            upsert(project);
            return "request has been successfully removed from project";
        }
        return "request removal operation failed";
    }
}

