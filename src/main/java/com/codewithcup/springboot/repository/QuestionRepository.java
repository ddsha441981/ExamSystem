package com.codewithcup.springboot.repository;

import com.codewithcup.springboot.model.examcontent.Question;
import com.codewithcup.springboot.model.examcontent.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {


    Set<Question> findByQuiz(Quiz quiz);
}
