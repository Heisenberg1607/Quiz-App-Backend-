package com.project.QuizApp.Service;


import com.project.QuizApp.Entity.Question;
import com.project.QuizApp.Entity.QuestionWrapper;
import com.project.QuizApp.Entity.Quiz;
import com.project.QuizApp.dao.QuestionDAO;
import com.project.QuizApp.dao.QuizDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDAO quizDao;

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionDAO.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();

        quiz.setQuizTitle(title);
        quiz.setQuestion(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);

        if (quiz.isPresent()) {
            Quiz quizMain = quiz.get();
            List<Question> questionsFromDB = quizMain.getQuestion();

            List<QuestionWrapper> questionsForUser = new ArrayList<>();

            for (Question q : questionsFromDB) {
                QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
                questionsForUser.add(qw);
            }
            return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public boolean checkAnswer(Integer id, String userAnswer) {

        Optional<Question> question = questionDAO.findById(id);

        if(question.get().getRightAnswer().equals(userAnswer)){
            return true;
        }
        return false;
    }
}