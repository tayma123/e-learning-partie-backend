package com.example.demo.tayma.Repository;

import com.example.demo.tayma.Entities.Question;
import com.example.demo.tayma.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question, Long> {
    List<Question> findByQuiz(Quiz quiz);
}
