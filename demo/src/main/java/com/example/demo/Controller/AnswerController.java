package com.example.demo.Controller;

import com.example.demo.Service.*;
import com.example.demo.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class AnswerController {
    /*
    private final QuizService quizService;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserServiceImpl userService;
    private final OptionsService optionsService;

    public AnswerController(QuizService quizService, QuestionService questionService, AnswerService answerService, UserServiceImpl userService) {
        this.quizService = quizService;
        this.questionService = questionService;
        this.answerService = answerService;
        this.userService = userService;
    }
    @GetMapping("/findByQuestionAndUser/{idQs}/{username}")
    public ResponseEntity<Answer> getAnswerByQuestionAndUser(@PathVariable("idQs") Long idQs,@PathVariable("username") String username) {
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
    @GetMapping("/submitResults")
    public ResponseEntity<>
    List<Question> questions = questionService.findByQuiz(quiz);
     for (Question q : questions)

    {
        Options CorrectOption=q.getCorrectOption();
        Options answer=q.
    }
*/
}
