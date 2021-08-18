package com.example.demo.tayma.Service;

import com.example.demo.tayma.Exception.CoursNotFoundException;

import com.example.demo.tayma.Repo.CoursRepo;
import com.example.demo.tayma.model.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import javax.transaction.Transactional;
import java.util.List;

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

    public Cours findCoursById(Long idCr) {
        return
                coursRepo.findCoursByIdCr(idCr).orElseThrow(() -> new CoursNotFoundException("cours not found"));
    }

    public Cours addCours(Cours cours) {

        return coursRepo.save(cours);
    }

    public Cours updateCours(Cours cours) {
        return coursRepo.save(cours);
    }

    public void deleteCours(Long idCr) {
        coursRepo.deleteCoursByIdCr(idCr);

    }

public void deleteCours(String name) {
            coursRepo.deleteCoursByName(name);
    }


    public Cours findCoursByTitre(String titre) {
        return coursRepo.findCoursByTitre(titre).orElseThrow(() -> new CoursNotFoundException("user not found"));
    }

    public Set <Cours> findByCatégorie(Long idCt) {   return coursRepo.findByCatégorie(idCt);
    }
}

