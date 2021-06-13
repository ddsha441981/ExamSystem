package com.codewithcup.springboot.controller;

import com.codewithcup.springboot.model.examcontent.Question;
import com.codewithcup.springboot.model.examcontent.Quiz;
import com.codewithcup.springboot.service.QuestionService;
import com.codewithcup.springboot.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value ="/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

//    Add questions
    @PostMapping("/")
    public ResponseEntity<Question> addQuestions(@RequestBody  Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

//    Update Questions
    @PutMapping("/")
    public ResponseEntity<Question> updateQuestions(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

//    getting all questions
    @GetMapping("/")
    public ResponseEntity<?> gettingAllQuestions(){
        return ResponseEntity.ok(this.questionService.getQuestions());
    }

//    getting questions by using questionId
    @GetMapping("/{quesId}")
    public Question getQuestionsById(@PathVariable("quesId") Long quesId){
        return this.questionService.getQuestion(quesId);
    }

//    Get any questions from any Quiz
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid){
//        Quiz quiz = new Quiz();
//        quiz.setqId(quizId);
//        Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);

       Quiz quiz  =  this.quizService.getQuiz(qid);
       Set<Question> questions = quiz.getQuestions();
       List list = new ArrayList(questions);
       if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())){
           list = list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
       }
       Collections.shuffle(list);

       return ResponseEntity.ok(list);
    }

    //    delete Questions by using questionId
    @DeleteMapping("/{quesId}")
    public void deleteQuestions(@PathVariable("quesId") Long quesId){
        this.questionService.deleteQuestion(quesId);
    }
}
