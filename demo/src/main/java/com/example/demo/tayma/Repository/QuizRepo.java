package com.example.demo.tayma.Repository;


<<<<<<< HEAD:demo/src/main/java/com/example/demo/tayma/Repository/QuizRepo.java

import com.example.demo.tayma.Entities.Cours;
import com.example.demo.tayma.Entities.Quiz;
=======
import com.example.demo.model.Quiz;
>>>>>>> e944f10b738061c10593560335e716ad80a8456c:demo/src/main/java/com/example/demo/Repo/QuizRepo.java
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz, Long> {


Quiz findByChapitre(Long idChap);
}
