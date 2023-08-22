package com.example.organizer.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Data
@Document
public class Item {
    @Id
    private String itemID;

    private String userId;
    private String title;
    private String description;

}
