package com.example.organizer.repositoriesImpl;

import com.example.organizer.daos.ItemDao;
import com.example.organizer.daos.UserDao;
import com.example.organizer.entities.Item;
import com.example.organizer.entities.User;
import com.example.organizer.repositories.OrganizerRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OrganizerRepositoryImpl implements OrganizerRepository {

    private final UserDao userDAO;
    private final ItemDao itemDao;

    public OrganizerRepositoryImpl(UserDao userDAO, ItemDao itemDao) {
        this.userDAO = userDAO;
        this.itemDao = itemDao;
    }

    public Boolean isUserExistingByEmail(String email) {
            return userDAO.existsByEmail(email);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userDAO.findById(id);
    }

    @Override
    public boolean updateUser(User user) {
        userDAO.save(user);
        return false;
    }

    @Override
    public boolean updateItem(Item item) {
        itemDao.save(item);
        return true;
    }

    @Override
    public boolean removeItemById(String id) {
        itemDao.deleteById(id);
        return true;
    }

    @Override
    public boolean getItemById(String id) {
        return false;
    }

    @Override
    public Optional<Item> getItemByUserId(String userId) {
        return itemDao.findByUserId(userId);
    }
}
