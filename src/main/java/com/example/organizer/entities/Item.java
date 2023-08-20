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
    private String userName;
    private String title;
    private String description;
    private ZonedDateTime startDate;
    private ZonedDateTime dueDate;
    private boolean recurring;
    private String interval;

}
