package com.example.demo.Controller;

import com.example.demo.Service.CatégorieService;
import com.example.demo.model.Catégorie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Catégorie> addUser(@RequestBody Catégorie catégorie){
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


