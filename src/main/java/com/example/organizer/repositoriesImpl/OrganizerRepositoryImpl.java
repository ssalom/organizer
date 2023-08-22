package com.example.organizer.repositoriesImpl;

import com.example.organizer.daos.ItemDao;
import com.example.organizer.daos.UserDao;
import com.example.organizer.entities.Item;
import com.example.organizer.entities.User;
import com.example.organizer.repositories.OrganizerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrganizerRepositoryImpl implements OrganizerRepository {

    private final UserDao userDAO;
    private final ItemDao itemDao;

    public OrganizerRepositoryImpl(UserDao userDAO, ItemDao itemDao) {
        this.userDAO = userDAO;
        this.itemDao = itemDao;
    }

    public boolean isUserExistingByEmail(String email) {
            return userDAO.existsByEmail(email);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userDAO.findById(id);
    }

    @Override
    public boolean updateUser(User user) {
        userDAO.save(user);
        return true;
    }

    public List<User> getUsers() { return userDAO.findAll().stream().toList();}

    public boolean deletedUserById(String userID) {
        userDAO.deleteById(userID);
        return true;
    }

    @Override
    public boolean updateItem(Item item) {
        itemDao.save(item);
        return true;
    }

    @Override
    public boolean deleteItemById(String id) {
        itemDao.deleteById(id);
        return true;
    }

    public Optional<Item> getItemById(String id) {
        return itemDao.findById(id);
    }

    public List<Item> getItemByUserId(String userId) {
        return itemDao.findByUserId(userId);
    }

}
