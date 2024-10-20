package com.project.QuizApp.dao;

import com.project.QuizApp.Entity.Question;
import com.project.QuizApp.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer> {


}