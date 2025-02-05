package com.example.Quiz_Application.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "questions")
public class Question {
    @Id
    private String id;
    private String quizId;
    private String questionText;
    private List<String> options;
    private String correctOption;
}
