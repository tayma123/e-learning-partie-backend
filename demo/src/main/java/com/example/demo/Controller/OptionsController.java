
package com.example.demo.Controller;

import com.example.demo.Service.OptionsService;
import com.example.demo.Service.QuestionService;
import com.example.demo.model.Options;
import com.example.demo.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("cours/chapitre/quiz/question/options")
public class OptionsController {
    private final OptionsService optionsService;
    private final QuestionService questionService;


    public OptionsController(OptionsService optionsService,QuestionService questionService) {
        this.optionsService = optionsService;
        this.questionService = questionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Options>> getOptions() {
        List<Options> optionsList = optionsService.findAll();
        return new ResponseEntity<>(optionsList, HttpStatus.OK);
    }
    @GetMapping("/findByQuestion/{idQs}")
    public ResponseEntity<List<Options>> getOptionsByQuestion(@PathVariable("idQs") Long idQs) {
        Question question=questionService.findById(idQs);
        List<Options> optionsList = question.getOptionsList();
        return new ResponseEntity<>(optionsList, HttpStatus.OK);
    }

    @GetMapping("/find/{idOpt}")
    public ResponseEntity<Options> getOption(@PathVariable("idOpt") Long idOpt) {

        Options options = optionsService.findById(idOpt);
        return new ResponseEntity<>(options, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{idOpt}")
    public ResponseEntity<?> deleteOptions(@PathVariable("idOpt") Long idOpt) {
        questionService.delete(idOpt);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add/{idQs}")
    public ResponseEntity<Options> addOptions(@RequestBody Options option , @PathVariable("idQs") Long idQs) {
        Question question=questionService.findById(idQs);
        question.addOption(option);
        option.setIdQs(idQs);
        Options newOptions = optionsService.save(option);
        return new ResponseEntity<>(newOptions, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/update")
    public ResponseEntity<Options> updateOptions(@RequestBody Options options) {
        Options UpdateOptions= optionsService.update(options);
        return new ResponseEntity<>(UpdateOptions, HttpStatus.OK);
    }
}
