package com.codewithcup.springboot.repository;

import com.codewithcup.springboot.model.examcontent.Category;
import com.codewithcup.springboot.model.examcontent.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
//    Business Method Logic
//    Fetching active Quizes only
      @Query(value = "SELECT active,* FROM quiz where active=true" , nativeQuery = true)
//    @Query("FROM Quiz as q WHERE q.active LIKE 'active%'")
public List<Quiz> getQuizByActiveOnly();

public List<Quiz> findBycategory(Category category);
public List<Quiz> findByActive(Boolean b);
public List<Quiz> findByCategoryAndActive(Category category, Boolean b);

}
