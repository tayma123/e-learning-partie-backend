<<<<<<< HEAD:demo/src/main/java/com/example/demo/tayma/Controller/CoursController.java
package com.example.demo.tayma.Controller;

import com.example.demo.tayma.Services.CoursService;
import com.example.demo.tayma.Entities.Cours;
=======
package com.example.demo.Controller;
import com.example.demo.Service.CatégorieService;
import com.example.demo.Service.CoursService;
import com.example.demo.Service.UserServiceImpl;
import com.example.demo.model.Catégorie;
import com.example.demo.model.Cours;
import com.example.demo.model.User;
>>>>>>> e944f10b738061c10593560335e716ad80a8456c:demo/src/main/java/com/example/demo/Controller/CoursController.java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cours")
public class CoursController {
    private  final CoursService coursService;
    private  final CatégorieService catégorieService;
    private  final UserServiceImpl userService;
    public CoursController(CoursService coursService, CatégorieService catégorieService, UserServiceImpl userService) {
        this.coursService = coursService;
        this.catégorieService = catégorieService;
        this.userService = userService;
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
    @GetMapping("/findByCategorie/{nomC}")
    public ResponseEntity <Set<Cours>> getCoursByCtegorie(@PathVariable("nomC") String nomC){
    Catégorie catégorie=catégorieService.findCatégorieByNomC(nomC);
    Set<Cours> coursList=catégorie.getCoursList();
        return new ResponseEntity<>(coursList, HttpStatus.OK);
    }
    @GetMapping("/findByUser/{username}")
    public ResponseEntity <Set<Cours>> getCoursByUser(@PathVariable("username") String username){
        User user=userService.findByUsername(username);
        Set<Cours> coursList=user.getUserCourses();
        return new ResponseEntity<>(coursList, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Cours> addCours(@RequestBody Cours cours){
        Cours newCours= coursService.addCours(cours);
        return new ResponseEntity<>(newCours, HttpStatus.CREATED);
    }
    @PostMapping("/addByCategorie/{idCt}")
    public ResponseEntity<Cours> addByCatégorie(@RequestBody Cours cours,@PathVariable("idCt") Long idCt){
        Catégorie catégorie=catégorieService.findCatégorieByIdCt(idCt);
        //User user=userService.findByUsername(username);
        catégorie.addCours(cours);
        //user.addCours(cours);
        cours.setIdCt(idCt);
       // cours.setUsername(username);
        Cours newCours= coursService.addCours(cours);
        return new ResponseEntity<>(newCours, HttpStatus.CREATED);
    }

    //@Secured(value={"ROLE_AGENT"})
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
}
