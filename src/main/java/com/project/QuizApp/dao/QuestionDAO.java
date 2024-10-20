package com.project.QuizApp.dao;

import com.project.QuizApp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDAO extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM Question q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true )
    List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
