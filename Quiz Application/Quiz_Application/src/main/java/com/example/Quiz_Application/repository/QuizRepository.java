package com.example.Quiz_Application.repository;

import com.example.Quiz_Application.model.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepository extends MongoRepository<Quiz, String> {

}

