package com.example.E_Commerce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private String name; // ADMIN or CUSTOMER

    // Getters and setters
}