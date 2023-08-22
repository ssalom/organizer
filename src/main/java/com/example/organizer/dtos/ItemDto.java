package com.example.organizer.dtos;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ItemDto {
    private String itemID;
    private String userId;
    private String title;
    private String description;
}
