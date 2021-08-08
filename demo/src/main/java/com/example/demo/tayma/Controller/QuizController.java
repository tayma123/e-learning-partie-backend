package com.example.demo.tayma.Controller;

import com.example.demo.tayma.Services.CoursService;
import com.example.demo.tayma.Services.QuizService;
import com.example.demo.tayma.Entities.Cours;
import com.example.demo.tayma.Entities.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;
    private final CoursService coursService;
@Autowired
    public QuizController(QuizService quizService, CoursService coursService) {
        this.quizService = quizService;
        this.coursService = coursService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getQuizs() {
        List<Quiz> quizes = quizService.findAll();
        return new ResponseEntity<>(quizes, HttpStatus.OK);
    }
    @GetMapping("/findByCours/{idCr}")
    public ResponseEntity<List<Quiz>> getQuizesByCours(@PathVariable("idCr") Long idCr) {
        Cours cours=coursService.findCoursById(idCr);
        List<Quiz> quizes = quizService.findByCours(cours);
        return new ResponseEntity<>(quizes, HttpStatus.OK);
    }

    @GetMapping("/find/{idQ}")
    public ResponseEntity<Quiz> getquiz(@PathVariable("idQ") Long idQ) {

        Quiz quiz = quizService.findById(idQ);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{idQ}")
    public ResponseEntity<?> deleteQuiz(@PathVariable("idQ") Long idQ) {
        quizService.delete(idQ);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add/{idQ}")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz , @PathVariable("idQ") Long idQ) {
        Cours cours=coursService.findCoursById(idQ);
        quiz.setCours(cours);
        Quiz newQuiz = quizService.save(quiz);
        return new ResponseEntity<>(newQuiz, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/update")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
        Quiz UpdateQuiz = quizService.update(quiz);
        return new ResponseEntity<>(UpdateQuiz, HttpStatus.OK);
    }
}
