package com.example.organizer.daos;

import com.example.organizer.entities.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends ListCrudRepository<User, String> {


}
