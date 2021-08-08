package com.example.demo.tayma.Repository;



import com.example.demo.tayma.Entities.Cours;
import com.example.demo.tayma.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepo extends JpaRepository<Quiz, Long> {

      List<Quiz> findByCours(Cours cours);

}
