package com.example.Quiz_Application.model;

import lombok.Data;

import java.util.Map;

@Data
public class Submission {
    private String userId;
    private Map<String, String> answers; // Key: Question ID, Value: User's Answer
}

