package com.example.demo.tayma.Services;


<<<<<<< HEAD:demo/src/main/java/com/example/demo/tayma/Services/QuizService.java
import com.example.demo.tayma.Exception.QuizNotFoundException;
import com.example.demo.tayma.Repository.QuizRepo;
import com.example.demo.tayma.Entities.Cours;
import com.example.demo.tayma.Entities.Quiz;
=======
import com.example.demo.Exception.QuizNotFoundException;
import com.example.demo.Repo.QuizRepo;
import com.example.demo.model.Quiz;
>>>>>>> e944f10b738061c10593560335e716ad80a8456c:demo/src/main/java/com/example/demo/Service/QuizService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("QuizService")
@Transactional
public class QuizService {
    private QuizRepo quizRepo;
    @Autowired

    public QuizService(QuizRepo quizRepo) {
        this.quizRepo = quizRepo;
    }
    public Quiz findById(Long idQ) {
        return  quizRepo.findById(idQ).orElseThrow(() -> new QuizNotFoundException("Quiz not found!"));
    }

    public List<Quiz> findAll() {
        return quizRepo.findAll();
    }


   public Quiz findByChapitre(Long idChap){
        return quizRepo.findByChapitre(idChap);
    }

    public Quiz save(Quiz quiz) {
        return quizRepo.save(quiz);
    }


    public void delete(Long idQ) {
        quizRepo.deleteById(idQ);
    }


    public Quiz update(Quiz quiz) {return quizRepo.save(quiz);
    }
}
