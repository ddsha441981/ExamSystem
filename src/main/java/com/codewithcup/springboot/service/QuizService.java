package com.codewithcup.springboot.service;

import com.codewithcup.springboot.model.examcontent.Category;
import com.codewithcup.springboot.model.examcontent.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizess();
    public Quiz getQuiz(Long qid);
    public void deleteQuiz(Long qid);
//    Bussiness Method
    public List<Quiz> gettingActiveQuizes();

   public  List<Quiz> getQuizzesByCategory(Category category);

   public List<Quiz> getActiveQuizzes();
   public List<Quiz> getActiveQuizzesOfCategory(Category category);
}
