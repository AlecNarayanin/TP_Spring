package com.ynov.tp_spring.services;

import com.ynov.tp_spring.entities.User;
import com.ynov.tp_spring.repositories.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User upsert(User user) {
        return userRepository.save(user);
    }

    public User getById(Integer id) {
        return userRepository.getById(id);
    }

    public void deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }


}
