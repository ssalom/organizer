package com.example.organizer.repositories;

import com.example.organizer.daos.UserDAO;
import com.example.organizer.entities.User;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private final UserDAO userDAO;

    public UserRepositoryImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public Optional<User> get(String id) {
        return userDAO.findById(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void remove(User user) {
        userDAO.delete(user);
    }
}
