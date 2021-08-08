package com.example.demo.tayma.Controller;

import com.example.demo.tayma.Services.QuestionService;
import com.example.demo.tayma.Services.QuizService;
import com.example.demo.tayma.Entities.Question;
import com.example.demo.tayma.Entities.Quiz;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;
    private final QuizService quizService;

    public QuestionController(QuestionService questionService, QuizService quizService) {
        this.questionService = questionService;
        this.quizService = quizService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getQuestions() {
        List<Question> questions = questionService.findAll();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
    @GetMapping("/findByQuiz/{idQ}")
    public ResponseEntity<List<Question>> getQuestionsByQuiz(@PathVariable("idQ") Long idQ) {
        Quiz quiz=quizService.findById(idQ);
        List<Question> questions = questionService.findByQuiz(quiz);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/find/{idQs}")
    public ResponseEntity<Question> getQuestion(@PathVariable("idQs") Long idQs) {

        Question question = questionService.findById(idQs);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{idQs}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("idQs") Long idQs) {
        questionService.delete(idQs);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add/{idQ}")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question , @PathVariable("idQ") Long idQ) {
        Quiz quiz=quizService.findById(idQ);
        question.setQuiz(quiz);
        Question newQuestion = questionService.save(question);
        return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        Question UpdateQuestion= questionService.update(question);
        return new ResponseEntity<>(UpdateQuestion, HttpStatus.OK);
    }
}
