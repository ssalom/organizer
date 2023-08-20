package com.example.organizer.controllers;

import com.example.organizer.entities.User;
import com.example.organizer.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizerController {

    private final UserService userService;

    public OrganizerController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/newUser")
    public ResponseEntity<Object> newUser(@RequestBody User newUser) {
        try {
            userService.createUser(newUser);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().build();
    }
}
