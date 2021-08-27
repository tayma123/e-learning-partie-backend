package com.example.demo.tayma.Controller;

import com.example.demo.tayma.Entities.Catégorie;
import com.example.demo.tayma.Services.CatégorieService;
import com.example.demo.tayma.Services.CoursService;
import com.example.demo.tayma.Entities.Cours;
import com.example.demo.tayma.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cours")
public class CoursController {
    private  final CoursService coursService;
    private  final CatégorieService catégorieService;
    private  final UserService userService;
    public CoursController(CoursService coursService, CatégorieService catégorieService, UserService userService) {
        this.coursService = coursService;
        this.catégorieService = catégorieService;
        this.userService = userService; }

    @GetMapping("/all")
    public ResponseEntity<List<Cours>> getAllCours(){
        List<Cours> cours=coursService.findAllCours();
        return new ResponseEntity<>(cours, HttpStatus.OK); }
    @GetMapping("/findByUsername/{userName}")
    public ResponseEntity<Set<Cours>> getCoursByUsername(@PathVariable("userName") String userName){
        Set<Cours> cours= coursService.findByUserName(userName);
        return new ResponseEntity<>(cours, HttpStatus.OK); }
    @PostMapping("/add")
    public ResponseEntity<Cours> addCours(@RequestBody Cours cours){
        Cours newCours= coursService.addCours(cours);
        return new ResponseEntity<>(newCours, HttpStatus.CREATED); }
    //Methode pour ajouter par un enseignant
    @PostMapping("/addByCategorie/{idCt}/{userName}")
    public ResponseEntity<Cours> addByCatégorie(@RequestBody Cours cours,@PathVariable("idCt") Long idCt,@PathVariable("userName") String userName){
        Catégorie catégorie=catégorieService.findCatégorieByIdCt(idCt);
        catégorie.addCours(cours);
        cours.setUserName(userName);
        cours.setIdCt(idCt);
        Cours newCours= coursService.addCours(cours);
        return new ResponseEntity<>(newCours, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Cours> updateUser(@RequestBody Cours cours){
        Cours UpdateCours= coursService.updateCours(cours);
        return new ResponseEntity<>(UpdateCours, HttpStatus.OK);
    }
    @DeleteMapping("/{idCr}")
    public ResponseEntity<?> deleteCours(@PathVariable("idCr") Long idCr) {
        coursService.deleteCours(idCr);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/find/{titre}")
    public ResponseEntity<Cours> getCoursByTitre(@PathVariable("titre") String titre){
        Cours cours= coursService.findCoursByTitre(titre);
        return new ResponseEntity<>(cours, HttpStatus.OK);
    }


    @GetMapping("/findByCatégorie/{idCt}")
    public ResponseEntity <Set<Cours>> getCoursByCtégorie(@PathVariable("idCt") Long idCt){
        Catégorie catégorie=catégorieService.findCatégorieByIdCt(idCt);
        Set<Cours> coursList=catégorie.getCoursList();
        return new ResponseEntity<>(coursList, HttpStatus.OK);
    }

}
