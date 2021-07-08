package com.codewithcup.springboot.controller;

import com.codewithcup.springboot.helper.ActiveQuizNotFoundException;
import com.codewithcup.springboot.helper.GlobalExceptionController;
import com.codewithcup.springboot.model.examcontent.Category;
import com.codewithcup.springboot.model.examcontent.Quiz;
import com.codewithcup.springboot.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //update Quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuizzes(@RequestBody Quiz quiz){

        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get all Quizzes at time
    @GetMapping("/")
    public ResponseEntity<?> gettingAllQuizzes(){
        return ResponseEntity.ok(this.quizService.getQuizess());
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


//    Getting spacfic quiz by category
    @GetMapping("/category/{cid}")
    public List<Quiz> getSpecficQuizByCategory(@PathVariable("cid") Long cid){
        Category category = new Category();
        category.setCid(cid);
        return this.quizService.getQuizzesByCategory(category);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////

    //Getting quiz only active quiz for user
    @GetMapping("/active-custom")
    public ResponseEntity<?> getActiveQuiz(){
        List<Quiz> activeQuizzes = this.quizService.gettingActiveQuizes();
//        If all quizzes are InActive
            if(activeQuizzes.isEmpty()==true){
                try {
                    throw new ActiveQuizNotFoundException();
                } catch (ActiveQuizNotFoundException e) {
                    e.printStackTrace();
                }
            }
        return ResponseEntity.ok(activeQuizzes);

    }

    @GetMapping("/active")
    public List<Quiz> getActiveQuizz(){
        return this.quizService.getActiveQuizzes();
    }

    @GetMapping("/active/category/{cid}")
    public List<Quiz> getActiveQuizzOfCategories(@PathVariable("cid") Long cid){
        Category category = new Category();
        category.setCid(cid);
        return this.quizService.getActiveQuizzesOfCategory(category);
    }
}
