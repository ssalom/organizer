package com.example.organizer.services;

import com.example.organizer.entities.User;
import com.example.organizer.repositoriesImpl.OrganizerRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final OrganizerRepositoryImpl organizerRepositoryImpl;

    public UserService(OrganizerRepositoryImpl organizerRepositoryImpl) {
        this.organizerRepositoryImpl = organizerRepositoryImpl;
    }

    public void createUser(User user) throws Exception {
        if (organizerRepositoryImpl.isUserExistingByEmail(user.getEmail())) {
            throw new Exception("User is already exisitng");
        }

        organizerRepositoryImpl.updateUser(user);
    }
}
