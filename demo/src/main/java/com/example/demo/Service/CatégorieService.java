package com.example.demo.Service;

import com.example.demo.Exception.CoursNotFoundException;
import com.example.demo.Repo.CatégorieRepo;
import com.example.demo.model.Catégorie;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CatégorieService {

    private final CatégorieRepo catégorieRepo;

    public CatégorieService(CatégorieRepo catégorieRepo) {
        this.catégorieRepo = catégorieRepo;
    }

    public List<Catégorie> findAllCatégories() {
        return catégorieRepo.findAll();
    }

    public Catégorie findCatégorieByIdCt(Long idCt) {
        return
                catégorieRepo.findCatégorieByIdCt(idCt).orElseThrow(() -> new CoursNotFoundException("categorie not found"));
    }

    public Catégorie addCatégorie(Catégorie catégorie) {

        return catégorieRepo.save(catégorie);
    }

    public Catégorie updateCatégorie(Catégorie catégorie) {
        return catégorieRepo.save(catégorie);
    }

    public void deleteCatégorie(Long idCt) {
        catégorieRepo.deleteCatégorieByIdCt(idCt);

    }

    public void deleteCatégorie(String NomC) {
        catégorieRepo.deleteCatégorieByNomC(NomC);

    }

    public Catégorie findCatégorieByNomC(String NomC) {
        return catégorieRepo.findCatégorieByNomC(NomC).orElseThrow(() -> new CoursNotFoundException("catégorie not found"));
    }
}
