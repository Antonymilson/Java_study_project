package com.example.Quiz_Application.repository;

import com.example.Quiz_Application.model.Result;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResultRepository extends MongoRepository<Result, String> {
    List<Result> findByQuizIdOrderByScoreDesc(String quizId);
}
