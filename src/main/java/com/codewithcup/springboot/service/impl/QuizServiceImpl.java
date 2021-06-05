package com.codewithcup.springboot.service.impl;

import com.codewithcup.springboot.model.examcontent.Quiz;
import com.codewithcup.springboot.repository.QuizRepository;
import com.codewithcup.springboot.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizess() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        Quiz quiz = new Quiz();
        quiz.setqId(quizId);
        this.quizRepository.delete(quiz);
    }
}
