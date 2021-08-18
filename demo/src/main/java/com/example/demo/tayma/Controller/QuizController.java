package com.example.demo.tayma.Controller;

import com.example.demo.tayma.Service.*;
import com.example.demo.tayma.model.Chapitre;

import com.example.demo.tayma.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cours/chapitre/quiz")
public class QuizController {
    private final QuizService quizService;
  /*  private final QuestionService questionService;
    private final AnswerService answerService;*/
    private final UserServiceImpl userService;
    private final ChapitreService chapitreService;
    @Autowired
    public QuizController(QuizService quizService, UserServiceImpl userService, ChapitreService chapitreService) {
        this.quizService = quizService;
        /*this.questionService = questionService;
        this.answerService = answerService;*/
        this.userService = userService;
        this.chapitreService = chapitreService;

    }
    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getQuizs() {
        List<Quiz> quizes = quizService.findAll();
        return new ResponseEntity<>(quizes, HttpStatus.OK);
    }



    @GetMapping("/findByChapitre/{idChap}")
    public ResponseEntity<Quiz> getQuizByChapitre(@PathVariable("idChap") Long idChap) {
        Chapitre chapitre = chapitreService.findChapitreByIdChap(idChap);
        Quiz quiz= chapitre.getQuiz();
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }
    @GetMapping("/find/{idQ}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable("idQ") Long idQ) {
        Quiz quiz = quizService.findById(idQ);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{idQ}")
    public ResponseEntity<?> deleteQuiz(@PathVariable("idQ") Long idQ) {
        quizService.delete(idQ);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add/{idChap}")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz , @PathVariable("idChap") Long idChap) {
        Chapitre chapitre = chapitreService.findChapitreByIdChap(idChap);
        quiz.setIdChap(idChap);
        Quiz newQuiz = quizService.save(quiz);
        chapitre.setQuiz(newQuiz);
        return new ResponseEntity<>(newQuiz, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/update")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
        Quiz UpdateQuiz = quizService.update(quiz);
        return new ResponseEntity<>(UpdateQuiz, HttpStatus.OK);
    }
/*
  @PostMapping("/submit/{username}")
    public ResponseEntity<String> ValidateQuizByUSer(@RequestBody Quiz quiz,@PathVariable("username") String username) {
        List<Question> questions = quiz.getQuestionList();
        int size = questions.size();
        User user = userService.findByUsername(username);
        int score=0;
        int score_faux=0;
        String Result="";
        for (Question q:questions){
            Options option =answerService.findByQuestionAndUser(q,user).getOption();
            if (option.getCorrect()==true){
                score+=1;
            }
            else
                score_faux+=1;
        }
        quiz.setScore(score);
        if (score/size*100>=50){
            quiz.setPassedByUser(true);
            Result="Congratulations! you're successfully completed this Quiz. You're ready for the next step!!";
        }
        else {
            Result="Sorry! you should repeat the test and get more than 50% correct answer to pass to the next step";
        }
        return new ResponseEntity<>(Result, HttpStatus.CREATED);
    }
*/
}
