package com.example.demo.tayma.Service;

import com.example.demo.tayma.Exception.QuestionNotFoundException;
import com.example.demo.tayma.Repo.QuestionRepo;
import com.example.demo.tayma.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("QuestionService")
@Transactional
public class QuestionService {
    private QuestionRepo questionRepo;
    @Autowired
    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }
    public Question findById(Long idQs) {
        return  questionRepo.findById(idQs).orElseThrow(() -> new QuestionNotFoundException("Question Not Found!!"));
    }

    public List<Question> findAll() {
        return questionRepo.findAll();
    }
    public Question save(Question question) {
        return questionRepo.save(question);
    }
    public void delete(Long idQs) {
        questionRepo.deleteById(idQs);
    }
    public Question update(Question question) {
        return questionRepo.save(question);
    }
}

