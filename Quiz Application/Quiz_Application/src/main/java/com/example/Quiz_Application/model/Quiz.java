package com.example.Quiz_Application.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "quizzes")
public class Quiz {
    @Id
    private String id;
    private String title;
    private String description;
}