package com.example.organizer.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data()
@Document()
public class User {
    @Id
    private String userID;

    @Indexed(unique = true)
    private String email;

    private String name;
    private String password;
}
