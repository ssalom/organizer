package com.example.organizer.services;

import com.example.organizer.entities.User;
import com.example.organizer.repositories.UserRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepositoryImpl userRepositoryImp;

    public UserService(UserRepositoryImpl userRepositoryImp) {
        this.userRepositoryImp = userRepositoryImp;
    }

    public void createUser(User user) throws Exception {
        if (userRepositoryImp.existsByEmail(user.getEmail())) {
            throw new Exception("User is already exisitng");
        }

        userRepositoryImp.save(user);
    }
}
