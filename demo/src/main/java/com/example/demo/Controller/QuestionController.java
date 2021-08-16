package com.example.demo.Controller;

import com.example.demo.Service.QuestionService;
import com.example.demo.Service.QuizService;
import com.example.demo.model.Question;
import com.example.demo.model.Quiz;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cours/chapitre/quiz/question")
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
        List<Question> questions = quiz.getQuestions();
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
        quiz.addQuestion(question);
        question.setIdQ(idQ);
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
