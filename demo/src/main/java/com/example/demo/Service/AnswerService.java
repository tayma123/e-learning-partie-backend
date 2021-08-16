package com.example.demo.Service;

import com.example.demo.Exception.QuestionNotFoundException;
import com.example.demo.Repo.AnswerRepo;
import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.model.Quiz;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("AnswerService")
@Transactional
public class AnswerService {

    private AnswerRepo answerRepo;
    public Answer findById(Long idAnswer) {
        return  answerRepo.findById(idAnswer).orElseThrow(() -> new QuestionNotFoundException("Question Not Found!!"));
    }

    public Answer save(Answer answer) {
        return answerRepo.save(answer);
    }


    public void delete(Long idAnswer) {
        answerRepo.deleteById(idAnswer);
    }


    public Answer update(Answer answer) {
        return answerRepo.save(answer);
    }
    public Answer findByQuestionAndUser(Question question, User user) {
        return answerRepo.findByQuestionAndUser(question,user);
    }
    public List<Answer> findAllByQuizAndUser(Quiz quiz, User user) {
        return answerRepo.findAllByUserAndQuiz(quiz,user);
    }

}
