package com.example.demo.tayma.Services;

import com.example.demo.tayma.Exception.CoursNotFoundException;

import com.example.demo.tayma.Repository.CoursRepo;
import com.example.demo.tayma.Entities.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class CoursService {
    private final CoursRepo coursRepo;
    @Autowired
    public CoursService(CoursRepo coursRepo) {
        this.coursRepo = coursRepo;
    }

    public List<Cours> findAllCours() {
        return coursRepo.findAll();
    }
    public Cours findCoursById(Long idCr) {return coursRepo.findCoursByIdCr(idCr).orElseThrow(() -> new CoursNotFoundException("cours not found")); }

    public Cours addCours(Cours cours) { return coursRepo.save(cours);}

    public Cours updateCours(Cours cours) { return coursRepo.save(cours); }

    public void deleteCours(Long idCr) { coursRepo.deleteCoursById(idCr); }

    public void deleteCours(String name) {
        coursRepo.deleteCoursByName(name);
    }

    public Cours findCoursByTitre(String titre) {
        return coursRepo.findCoursByTitre(titre).orElseThrow(() -> new CoursNotFoundException("Cours not found"));
    }
    public Set<Cours> findByUserName(String userName) {  return coursRepo.findCoursByUserName(userName).orElseThrow(() -> new CoursNotFoundException("user not found"));

    }
    public Set<Cours> findByCatégorie(Long idCt) {  return coursRepo.findCoursByCatégorie(idCt).orElseThrow(() -> new CoursNotFoundException("Cours not found"));

    }
}


