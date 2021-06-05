package com.codewithcup.springboot.repository;

import com.codewithcup.springboot.model.examcontent.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
