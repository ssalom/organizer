package com.example.organizer.controllers;

import com.example.organizer.entities.User;
import com.example.organizer.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/newUser")
    public ResponseEntity<Object> newUser(@RequestBody User newUser) {
        userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
