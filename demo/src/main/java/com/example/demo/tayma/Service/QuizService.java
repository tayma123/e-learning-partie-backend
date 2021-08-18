package com.example.demo.tayma.Service;


import com.example.demo.tayma.Exception.QuizNotFoundException;
import com.example.demo.tayma.Repo.QuizRepo;
import com.example.demo.tayma.model.Quiz;
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
