package com.example.demo.Controller;

import com.example.demo.Service.ChapitreService;
import com.example.demo.Service.CoursService;
import com.example.demo.model.Chapitre;
import com.example.demo.model.Cours;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cours/chapitre")
public class ChapitreController {
    private final ChapitreService chapitreService;
    private final CoursService coursService;

    public ChapitreController(ChapitreService chapitreService, CoursService coursService) {
        this.chapitreService = chapitreService;
        this.coursService = coursService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Chapitre>> getChapitres() {
        List<Chapitre> chapitres = chapitreService.findAll();
        return new ResponseEntity<>(chapitres, HttpStatus.OK);
    }
    @GetMapping("/findByCours/{idCr}")
    public ResponseEntity<List<Chapitre>> getChpitreByCours(@PathVariable("idCr") Long idCr) {
        Cours cours=coursService.findCoursById(idCr);
        List<Chapitre> chapitres = cours.getChapitres();
        return new ResponseEntity<>(chapitres, HttpStatus.OK);
    }

    @GetMapping("/find/{idChap}")
    public ResponseEntity<Chapitre> getChapitre(@PathVariable("idChap") Long idChap) {
        Chapitre chapitre = chapitreService.findChapitreByIdChap(idChap);
        return new ResponseEntity<>(chapitre, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{idChap}")
    public ResponseEntity<?> deleteChapitre(@PathVariable("idChap") Long idChap) {
        chapitreService.delete(idChap);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add/{idCr}")
    public ResponseEntity<Chapitre> addChapitre(@RequestBody Chapitre chapitre , @PathVariable("idCr") Long idCr) {
        Cours cours=coursService.findCoursById(idCr);
        cours.addChapitre(chapitre);
        chapitre.setIdCr(idCr);
        Chapitre newChapitre = chapitreService.save(chapitre);
        return new ResponseEntity<>(newChapitre, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update")
    public ResponseEntity<Chapitre> updateChapitre(@RequestBody Chapitre chapitre) {
        Chapitre UpdateChapitre= chapitreService.update(chapitre);
        return new ResponseEntity<>(UpdateChapitre, HttpStatus.OK);
    }
}
