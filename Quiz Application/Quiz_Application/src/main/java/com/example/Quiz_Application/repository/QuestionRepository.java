package com.example.Quiz_Application.repository;

import com.example.Quiz_Application.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {
    List<Question> findByQuizId(String quizId);
}
