package com.ynov.tp_spring.services;

import com.ynov.tp_spring.entities.Project;
import com.ynov.tp_spring.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public Project upsert(Project p){
        return projectRepository.save(p);
    }

    public Project getById(Integer id){
        return  projectRepository.getById(id);
    }
    public void deleteById(Integer id ){
        if(projectRepository.existsById(id)){
            projectRepository.deleteById(id);
        }
    }


}
