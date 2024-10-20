package com.project.QuizApp.Service;

import com.project.QuizApp.Entity.Question;
import com.project.QuizApp.dao.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getAllQuestions() {

        return questionDAO.findAll();


    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDAO.findByCategory(category);
    }

    public String add(Question question) {
        questionDAO.save(question);
        return "success";
    }
}
