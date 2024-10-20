package com.project.QuizApp.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quizID;
    private String quizTitle;

    @ManyToMany
    private List<Question> question;


}
