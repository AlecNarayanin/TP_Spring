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

    public Request upsert(Request request) {
        return requestRepository.save(request);
    }

    public Request getById(Integer id) {
        return requestRepository.getById(id);
    }

    public void delete(Integer id) {
        if (requestRepository.existsById(id)) {
            requestRepository.deleteById(id);
        }
    }

    public List<Request> getAll() {
        return requestRepository.findAll();
    }
}
