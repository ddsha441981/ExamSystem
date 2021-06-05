package com.codewithcup.springboot.service;

import com.codewithcup.springboot.model.examcontent.Question;
import com.codewithcup.springboot.model.examcontent.Quiz;

import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestions();
    public Question getQuestion(Long questionId);
    public Set<Question> getQuestionsOfQuiz(Quiz quiz);
}
