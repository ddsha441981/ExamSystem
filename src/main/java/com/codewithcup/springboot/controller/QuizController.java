package com.codewithcup.springboot.controller;

import com.codewithcup.springboot.model.examcontent.Quiz;
import com.codewithcup.springboot.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value ="/quiz")
@CrossOrigin("*")
public class QuizController {
    @Autowired
    private QuizService quizService;

    //add quizzes
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuizess(@RequestBody Quiz quiz){
        Quiz quiz1 = this.quizService.addQuiz(quiz);
        return ResponseEntity.ok(quiz1);
    }

    //update Quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuizzes(@RequestBody Quiz quiz){

        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get all Quizzes at time
    @GetMapping("/")
    public ResponseEntity<?> gettingAllQuizzes(){
        return ResponseEntity.ok( this.quizService.getQuizess());

    }

    // get quiz using by id

    @GetMapping("/{qid}")
    public Quiz getQuizeById(@PathVariable("qid") Long qid){
        return this.quizService.getQuiz(qid);
    }

    // delete Quizzes
    @DeleteMapping("/{qid}")
    public void deleteQuiz(@PathVariable("qid") Long qid){
        this.quizService.deleteQuiz(qid);
    }
}
