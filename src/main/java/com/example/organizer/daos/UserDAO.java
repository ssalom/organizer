package com.example.organizer.daos;

import com.example.organizer.entities.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserDAO extends ListCrudRepository<User, String> {

    Boolean existsByEmail(String email);

}
