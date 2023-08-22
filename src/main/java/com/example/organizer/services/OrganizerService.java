package com.example.organizer.services;

import com.example.organizer.entities.Item;
import com.example.organizer.entities.User;
import com.example.organizer.repositoriesImpl.OrganizerRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {

    private final OrganizerRepositoryImpl organizerRepositoryImpl;

    public OrganizerService(OrganizerRepositoryImpl organizerRepositoryImpl) {
        this.organizerRepositoryImpl = organizerRepositoryImpl;
    }

    public void createUser(User user) throws Exception {
        if (organizerRepositoryImpl.isUserExistingByEmail(user.getEmail())) {
            throw new Exception("User is already exisitng");
        }

        organizerRepositoryImpl.updateUser(user);
    }

    public void updateUser(User user) throws Exception {
        Optional<User> existingUser = getUserById(user.getUserID());
        if (existingUser.isEmpty()) {
            throw new Exception("User not found");
        }

        if (user.getEmail() != null && !user.getEmail().isBlank() && !existingUser.get().getEmail().equals(user.getEmail())) {
            existingUser.get().setEmail(user.getEmail());
        }

        if (user.getName() != null && !user.getName().isBlank() && !existingUser.get().getName().equals(user.getName())) {
            existingUser.get().setName(user.getName());
        }

        organizerRepositoryImpl.updateUser(existingUser.get());
    }

    public Optional<User> getUserById(String userId) throws Exception {
        Optional<User> user = organizerRepositoryImpl.getUserById(userId);
        if (user.isEmpty()) {
            throw new Exception("User not found");
        }

        return user;
    }

    public void deletedUserById(String userId) {
        organizerRepositoryImpl.deletedUserById(userId);
    }

    public List<User> getUsers() {
        return organizerRepositoryImpl.getUsers();
    }

    public List<Item> getItemsByUser(String userID) {
        return organizerRepositoryImpl.getItemByUserId(userID);
    }

    public void createItem(Item item) {
        organizerRepositoryImpl.updateItem(item);
    }

    public void updateItem(Item item) throws Exception {
        Optional<Item> existingItem = getItemById(item.getItemID());
        if (existingItem.isEmpty()) {
            throw new Exception("Item not found.");
        }

        if (item.getTitle() != null && !item.getTitle().isBlank() && !existingItem.get().getTitle().equals(item.getTitle())) {
            existingItem.get().setTitle(item.getTitle());
        }

        if (item.getDescription() != null && !item.getDescription().isBlank() && !existingItem.get().getDescription().equals(item.getDescription())) {
            existingItem.get().setDescription(item.getDescription());
        }

        if (item.getUserId() != null && !item.getUserId().isBlank() && !existingItem.get().getUserId().equals(item.getUserId())) {
            existingItem.get().setUserId(item.getUserId());
        }

        organizerRepositoryImpl.updateItem(existingItem.get());
    }

    public Optional<Item> getItemById(String itemID) {
        return organizerRepositoryImpl.getItemById(itemID);
    }

    public boolean deletedItemById(String itemID) {
        return organizerRepositoryImpl.deleteItemById(itemID);
    }
}
