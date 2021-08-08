package com.example.demo.tayma.Services;

import com.example.demo.tayma.Exception.QuestionNotFoundException;
import com.example.demo.tayma.Repository.AnswerRepo;
import com.example.demo.tayma.Entities.Answer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
