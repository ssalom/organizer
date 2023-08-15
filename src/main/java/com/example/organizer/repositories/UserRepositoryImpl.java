package com.example.organizer.repositories;

import com.example.organizer.daos.UserDAO;
import com.example.organizer.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
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

    public Boolean existsByEmail(String email) {
            return userDAO.existsByEmail(email);
    }
}
