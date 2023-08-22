package com.example.organizer.daos;

import com.example.organizer.entities.Item;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ItemDao extends ListCrudRepository<Item, String> {
    List<Item> findByUserId(String userId);
}
