package com.example.demo.Controller;

import com.example.demo.Service.*;
import com.example.demo.model.*;
import com.example.demo.model.Answer;
import com.example.demo.model.Options;
import com.example.demo.model.Question;
import com.example.demo.model.Quiz;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("cours/chapitre/quiz/question/answer")
public class AnswerController {

    private QuizService quizService;
    private QuestionService questionService;
    private AnswerService answerService;
    private UserServiceImpl userService;
    private OptionsService optionsService;

    public AnswerController(QuizService quizService, QuestionService questionService, AnswerService answerService, UserServiceImpl userService, OptionsService optionsService) {
        this.quizService = quizService;
        this.questionService = questionService;
        this.answerService = answerService;
        this.userService = userService;
        this.optionsService = optionsService;
    }
    @GetMapping("/findByQuestionAndUser/{idQs}/{username}")
    public ResponseEntity<Answer> getAnswerByQuestionAndUser(@PathVariable("idQs") Long idQs, @PathVariable("username") String username) {
        Question question=questionService.findById(idQs);
        User user=userService.findByUsername(username);
        Answer answer = answerService.findByQuestionAndUser(question,user);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }
    @GetMapping("/findByQuizAndUser/{idQ}/{username}")
    public ResponseEntity <List<Answer>> getAllAnswersByQuizAndUser(@PathVariable("idQ") Long idQ,@PathVariable("username") String username) {
        Quiz quiz=quizService.findById(idQ);
        User user=userService.findByUsername(username);
        List <Answer> answers = answerService.findAllByQuizAndUser(quiz,user);
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }
    @PostMapping("/AnswerValidation/{username}/{idQs}/{idOpt}")
    public ResponseEntity<Answer> addAnswerByQuestion(@RequestBody Answer answer , @PathVariable("username") String username, @PathVariable("idQs") Long idQs,@PathVariable("idOpt") Long idOpt) {
        Question question=questionService.findById(idQs);
        Options option=optionsService.findById(idOpt);
        answer.setQuestion(question);
        answer.setQuiz();
        answer.setOption(option);
        Answer newAnswer = answerService.save(answer);
        return new ResponseEntity<>(newAnswer, HttpStatus.CREATED);
    }

}
