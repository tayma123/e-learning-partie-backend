package com.example.demo.tayma.Repo;


import com.example.demo.tayma.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz, Long> {


Quiz findByChapitre(Long idChap);
}
