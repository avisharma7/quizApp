package com.example.quizApp.services;

import com.example.quizApp.DAO.QuestionDao;
import com.example.quizApp.DAO.QuizDao;
import com.example.quizApp.Model.Question;
import com.example.quizApp.Model.QuestionWrapper;
import com.example.quizApp.Model.Quiz;
import com.example.quizApp.Model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private static final Logger log = LoggerFactory.getLogger(QuizService.class);


    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {

        System.out.println("Called from the Service class");

        List<Question> questions =  questionDao.findRandomQuestionByCategory(category, numQ);


        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Quiz created", HttpStatus.CREATED);




    }

    public  ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        System.out.println("Called from the Service class");
        Optional<Quiz> quiz = quizDao.findById(id);
        //convert questions to question wrapper, because we are returning wrapper
        List<Question>questionsFromDB = quiz.get().getQuestions();
        log.info("Questions from DB: " + questionsFromDB);
        List<QuestionWrapper> questionForUsers = new ArrayList<>();

        for(Question question : questionsFromDB) {
            QuestionWrapper questionWrapper = new QuestionWrapper(Math.toIntExact(question.getId()), question.getQuestionTitle(),question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
            questionForUsers.add(questionWrapper);
            log.info(questionWrapper.getQuestionTitle());
        }
        log.info("Questions for Users: " + questionForUsers);
        return new ResponseEntity<>(questionForUsers, HttpStatus.OK);
    }


    public ResponseEntity<Integer> CaluclateScore(Integer id, List<Response> responses) {
        log.info("Called from the Service class");
        Quiz quiz = quizDao.findById(id).get(); // getting the optional object
        List<Question> questions = quiz.getQuestions();


        int score = 0;
        int i = 0; //to iterate over questions
        for (Response r : responses) {
            if (r.getResponse().equals(questions.get(i).getRightAnswer())) {
                score++;
            }
            i++;
        }
        log.info("Score: " + score);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
