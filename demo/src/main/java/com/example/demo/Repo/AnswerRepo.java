package com.example.demo.Repo;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Quiz;
import java.util.List;

public interface AnswerRepo extends JpaRepository<Answer,Long> {
    Answer findByQuestionAndUser (Question question, User user);

    List<Answer> findAllByUserAndQuiz(Quiz quiz, User user);
}
