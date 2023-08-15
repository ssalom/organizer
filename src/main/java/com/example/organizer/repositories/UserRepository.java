package com.example.organizer.repositories;

import com.example.organizer.entities.User;

import java.util.Optional;

public interface UserRepository {
Optional<User> get(String id);
void save(User user);
void remove(User user);

Boolean existsByEmail(String email);

}
