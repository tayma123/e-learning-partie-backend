package com.example.demo.tayma.Controller;

import com.example.demo.tayma.Services.CatégorieService;
import com.example.demo.tayma.Entities.Catégorie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categorie")

public class CatégorieController {
    private  final CatégorieService catégorieService;

    public CatégorieController(CatégorieService catégorieService) {
        this.catégorieService = catégorieService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Catégorie>> getAllCatégories(){
        List<Catégorie> catégories=catégorieService.findAllCatégories();
        return new ResponseEntity<>(catégories, HttpStatus.OK);
    }

    @GetMapping("/find/{NomC}")
    public ResponseEntity<Catégorie> getCatégorieByNomc(@PathVariable("NomC") String NomC){
        Catégorie catégorie= catégorieService.findCatégorieByNomC(NomC);
        return new ResponseEntity<>(catégorie, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Catégorie> addCatégorie(@RequestBody Catégorie catégorie){
        Catégorie newCatégorie= catégorieService.addCatégorie(catégorie);
        return new ResponseEntity<>(newCatégorie, HttpStatus.CREATED);
    }
    //@Secured(value={"ROLE_AGENT"})
    @PostMapping("/update")
    public ResponseEntity<Catégorie> updateCatégorie(@RequestBody Catégorie catégorie){
        Catégorie UpdateCatégorie= catégorieService.updateCatégorie(catégorie);
        return new ResponseEntity<>(UpdateCatégorie, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{NomC}")
    public ResponseEntity<?> deleteCatégorie(@PathVariable("NomC") String NomC){
        catégorieService.deleteCatégorie(NomC);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}


