package com.example.organizer.daos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user")
public class UserDAO {
    @Id
    private String userID;

    @Indexed(unique = true)
    private String email;

    private String name;
    private String role;
}
