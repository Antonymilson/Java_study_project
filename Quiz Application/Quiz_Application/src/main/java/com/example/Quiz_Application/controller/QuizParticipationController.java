package com.example.Quiz_Application.controller;

import com.example.Quiz_Application.model.Question;
import com.example.Quiz_Application.model.Result;
import com.example.Quiz_Application.model.Submission;
import com.example.Quiz_Application.repository.QuestionRepository;
import com.example.Quiz_Application.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizParticipationController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ResultRepository resultRepository;

    @PostMapping("/{quizId}/submit")
    public Result submitQuiz(@PathVariable String quizId, @RequestBody Submission submission) {
        // Fetch questions for the quiz
        List<Question> questions = questionRepository.findByQuizId(quizId);

        // Calculate score
        int score = 0;
        for (Question question : questions) {
            String userAnswer = submission.getAnswers().get(question.getId());
            if (userAnswer != null && userAnswer.equals(question.getCorrectOption())) {
                score += 10; // Example: 10 points per correct answer.
            }
        }

        // Save result
        Result result = new Result();
        result.setUserId(submission.getUserId());
        result.setQuizId(quizId);
        result.setScore(score);
        return resultRepository.save(result);
    }

    @GetMapping("/{quizId}/start")
    public List<Question> startQuiz(@PathVariable String quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
