package com.example.demo.Controller;

import com.example.demo.Service.CoursService;
import com.example.demo.model.Cours;
import com.example.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cours")
public class CoursController {
    private  final CoursService coursService;

    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cours>> getAllCours(){
        List<Cours> cours=coursService.findAllCours();
        return new ResponseEntity<>(cours, HttpStatus.OK);
    }

    @GetMapping("/find/{titre}")
    public ResponseEntity<Cours> getCoursByTitre(@PathVariable("titre") String titre){
       Cours cours= coursService.findCoursByTitre(titre);
        return new ResponseEntity<>(cours, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Cours> addUser(@RequestBody Cours cours){
        Cours newCours= coursService.addCours(cours);
        return new ResponseEntity<>(newCours, HttpStatus.CREATED);
    }
    //@Secured(value={"ROLE_AGENT"})
    @PostMapping("/update")
    public ResponseEntity<Cours> updateUser(@RequestBody Cours cours){
        Cours UpdateCours= coursService.updateCours(cours);
        return new ResponseEntity<>(UpdateCours, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{titre}")
    public ResponseEntity<?> deleteCours(@PathVariable("titre") String titre){
        coursService.deleteCours(titre);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
