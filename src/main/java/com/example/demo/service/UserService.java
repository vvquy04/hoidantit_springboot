package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String HandleHello() {
        return "Hello from service";
    }

    public User handlSaveUser(User user) {
        return this.userRepository.save(user);
    }
}
