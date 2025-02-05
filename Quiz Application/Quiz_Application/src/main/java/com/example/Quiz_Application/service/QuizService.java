package com.example.Quiz_Application.service;

import com.example.Quiz_Application.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    public int calculateScore(List<Question> questions, Map<String, String> userAnswers) {
        int score = 0;

        for (Question question : questions) {
            String userAnswer = userAnswers.get(question.getId());
            if (userAnswer != null && userAnswer.equals(question.getCorrectOption())) {
                score += 10; // Example scoring logic.
            }
        }
        return score;
    }
}
