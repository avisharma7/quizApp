package com.example.quizApp.Controller;


import com.example.quizApp.Model.Question;
import com.example.quizApp.Model.QuestionWrapper;
import com.example.quizApp.Model.Quiz;
import com.example.quizApp.Model.Response;
import com.example.quizApp.services.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
@Slf4j
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String title){
        System.out.println("Called from the Controller class");

        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity <List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){

        //we can't display the right answer to the user, hence create a wrapper of Question, where rightasnwer is missing
    return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.CaluclateScore(id,responses);
    }

}
