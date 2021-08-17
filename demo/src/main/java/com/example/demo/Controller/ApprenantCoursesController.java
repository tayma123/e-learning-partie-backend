package com.example.demo.Controller;

import com.example.demo.Service.ApprenantCoursesService;
import com.example.demo.Service.CoursService;
import com.example.demo.Service.UserServiceImpl;
import com.example.demo.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/enrolledCourses")
public class ApprenantCoursesController  {
    private final ApprenantCoursesService apprenantCoursesService;
    private final UserServiceImpl userService;
    private final CoursService coursService;
    public ApprenantCoursesController(ApprenantCoursesService apprenantCoursesService, UserServiceImpl userService, CoursService coursService) {
        this.apprenantCoursesService = apprenantCoursesService;
        this.userService = userService;
        this.coursService = coursService;
    }
    @GetMapping("/findByUser/{username}")
    public ResponseEntity<List<ApprenantCourses>> getInscriptionsByUser(@PathVariable("username") String username) {
        User user=userService.findByUsername(username);
        List<ApprenantCourses> inscriptions= user.getInscriptions();
        return new ResponseEntity<>(inscriptions, HttpStatus.OK);
    }
    @GetMapping("/findCoursesByUser/{username}")
    public ResponseEntity<List<Cours>> getCoursesByApprenant(@PathVariable("username") String username) {
        User user=userService.findByUsername(username);
        List<ApprenantCourses> inscriptions= user.getInscriptions();
        List <Cours> ApprenantCourses=null;
        for (ApprenantCourses i:inscriptions ){
            Cours cours1=coursService.findCoursById(i.getIdCr());
            ApprenantCourses.add(cours1);
        }
        return new ResponseEntity<>(ApprenantCourses, HttpStatus.OK);
    }
    @PostMapping("/add/{username}/{idCr}")
    public ResponseEntity<ApprenantCourses> addInscription(@RequestBody ApprenantCourses inscription ,@PathVariable("username") String username, @PathVariable("idCr") Long idCr) {
        User user=userService.findByUsername(username);
        Cours cours=coursService.findCoursById(idCr);
        cours.addInscription(inscription);
        user.addInscription(inscription);
        inscription.setIdCr(idCr);
        inscription.setUsername(username);

        ApprenantCourses newApprenantCourses = apprenantCoursesService.save(inscription);
        return new ResponseEntity<>(newApprenantCourses, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/update")
    public ResponseEntity<ApprenantCourses> updateInscription(@RequestBody ApprenantCourses apprenantCourses) {
        ApprenantCourses UpdateInscription= apprenantCoursesService.update(apprenantCourses);
        return new ResponseEntity<>(UpdateInscription, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{idAC}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("idAC") Long idAC) {
        apprenantCoursesService.delete(idAC);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
