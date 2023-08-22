package com.example.organizer.repositories;

import com.example.organizer.entities.Item;
import com.example.organizer.entities.User;

import java.util.List;
import java.util.Optional;

public interface OrganizerRepository {
Optional<User> getUserById(String id);
boolean updateUser(User user);
boolean isUserExistingByEmail(String email);
boolean deletedUserById(String userId);
List<Item> getItemByUserId(String userId);
List<User> getUsers();

boolean updateItem(Item item);
boolean deleteItemById(String id);
Optional<Item> getItemById(String id);

}
