package com.example.demo.Repo;


import com.example.demo.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz, Long> {


Quiz findByChapitre(Long idChap);
}
