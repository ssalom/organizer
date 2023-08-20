package com.example.organizer.daos;

import com.example.organizer.entities.Item;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ItemDao extends ListCrudRepository<Item, String> {
    Optional<Item> findByUserId(String userId);
}
