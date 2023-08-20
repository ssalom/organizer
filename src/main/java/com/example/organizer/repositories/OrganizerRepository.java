package com.example.organizer.repositories;

import com.example.organizer.entities.Item;
import com.example.organizer.entities.User;

import java.util.Optional;

public interface OrganizerRepository {
Optional<User> getUserById(String id);
boolean updateUser(User user);
Boolean isUserExistingByEmail(String email);

boolean updateItem(Item item);
boolean removeItemById(String id);
boolean getItemById(String id);
Optional<Item> getItemByUserId(String userId);


}
