package com.example.demo.tayma.Service;

import com.example.demo.tayma.Exception.QuestionNotFoundException;
import com.example.demo.tayma.model.Options;
import com.example.demo.tayma.model.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.example.demo.tayma.Repo.OptionsRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("OptionsService")
@Transactional
public class OptionsService {

    private OptionsRepo optionsRepo;
    @Autowired
    public OptionsService(OptionsRepo optionsRepo) {
        this.optionsRepo = optionsRepo;
    }

  /*  public static List<Options> getAllTrueOptions() {
    }*/

    public Options findById(Long idOpt) {
        return  optionsRepo.findById(idOpt).orElseThrow(() -> new QuestionNotFoundException("Options Not Found!!"));
    }
    public List<Options> findAll() {
        return optionsRepo.findAll();
    }
    public List<Options> findByQuestion(Question question) {
        return optionsRepo.findByQuestion(question);
    }
    public Options save(Options options) {
        return optionsRepo.save(options);
    }
    public void delete(Long idOpt) {
        optionsRepo.deleteById(idOpt);
    }
    public Options update(Options options) {
        return optionsRepo.save(options);
    }
}
