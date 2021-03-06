package com.ynov.tp_spring.services;

import com.ynov.tp_spring.entities.Request;
import com.ynov.tp_spring.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public boolean handleRequestStatus(Integer id, Request.RequestStatus status) {
        if (requestRepository.existsById(id)) {
            Request request = requestRepository.getById(id);
            request.setStatus(status);
            upsert(request);
            return true;
        }
        return false;
    }

    public Request upsert(Request request) {
        return requestRepository.save(request);
    }

    public Request getById(Integer id) {
        return requestRepository.getById(id);
    }

    public boolean delete(Integer id) {
        if (requestRepository.existsById(id)) {
            requestRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    /*public List<Request> getAllByProject(Integer projectId) {
        return requestRepository.findByProjectId(projectId);
    }*/
}
