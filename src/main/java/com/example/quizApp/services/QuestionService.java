package com.example.quizApp.services;

import com.example.quizApp.DAO.QuestionDao;
import com.example.quizApp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service

public class QuestionService {
     private static final Logger log = LoggerFactory.getLogger(QuestionService.class);
     @Autowired
     QuestionDao questionDao;
     public ResponseEntity<List<Question>> getAllQuestions() {
          try {
               return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
          }catch (Exception e){
               e.printStackTrace();
          }
          return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
     }

     public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
          try {
               return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
          }catch (Exception e){
               e.printStackTrace();
          }
          return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

     }

     public ResponseEntity<String> addQuestion(Question question) {
          questionDao.save(question);
          return new ResponseEntity<>("success",HttpStatus.CREATED);
     }
}
