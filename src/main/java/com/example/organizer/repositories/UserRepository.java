package com.example.organizer.repositories;

import com.example.organizer.daos.UserDAO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDAO, String> {
}
