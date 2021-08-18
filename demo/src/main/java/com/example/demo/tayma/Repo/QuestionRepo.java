package com.example.demo.tayma.Repo;

import com.example.demo.tayma.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Long> {

}
