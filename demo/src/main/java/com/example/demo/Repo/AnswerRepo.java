package com.example.demo.Repo;

import com.example.demo.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer,Long> {
}
