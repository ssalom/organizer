package com.example.organizer.controllers;

import com.example.organizer.entities.User;
import com.example.organizer.services.OrganizerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizerController {

    private final OrganizerService organizerService;

    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @PostMapping("/newUser")
    public ResponseEntity<Object> newUser(@RequestBody User newUser) {
        try {
            organizerService.createUser(newUser);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().build();
    }
}
