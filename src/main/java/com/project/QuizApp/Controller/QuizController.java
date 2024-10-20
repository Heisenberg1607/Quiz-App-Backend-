package com.project.QuizApp.Controller;


import com.project.QuizApp.Entity.Question;
import com.project.QuizApp.Entity.QuestionWrapper;
import com.project.QuizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){

        quizService.createQuiz(category,numQ, title);
        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    @GetMapping("get/{Id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizFromId(@PathVariable Integer Id){
        return quizService.getQuiz(Id);
    }

    @PostMapping("userResponse")
    public String responseCheck(@RequestParam Integer id, @RequestParam String userAnswer){
        Boolean answer = quizService.checkAnswer(id,userAnswer);
        if(answer){
            return "correct";
        }else{
            return "false";
        }
    }
}
