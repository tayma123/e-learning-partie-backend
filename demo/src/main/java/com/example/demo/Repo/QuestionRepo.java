package com.example.demo.Repo;

import com.example.demo.model.Question;
import com.example.demo.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question, Long> {
    List<Question> findByQuiz(Quiz quiz);
}
