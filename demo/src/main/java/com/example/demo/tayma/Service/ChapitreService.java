package com.example.demo.tayma.Service;

import com.example.demo.tayma.Exception.CoursNotFoundException;
import com.example.demo.tayma.Repo.ChapitreRepo;
import com.example.demo.tayma.model.Chapitre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("chapitreService")
@Transactional
public class ChapitreService {
    private ChapitreRepo chapitreRepo;
    @Autowired
    public ChapitreService(ChapitreRepo chapitreRepo) {
        this.chapitreRepo = chapitreRepo;
    }
    public Chapitre findChapitreByIdChap(Long idChap) {
        return
                chapitreRepo.findChapitreByIdChap(idChap).orElseThrow(() -> new CoursNotFoundException("Chapitre not found"));
    }

    public List<Chapitre> findAll() {
        return chapitreRepo.findAll();
    }
    public Chapitre save(Chapitre chapitre) {
        return chapitreRepo.save(chapitre);
    }
    public void delete(Long idChap) {
        chapitreRepo.deleteById(idChap);
    }
    public Chapitre update(Chapitre chapitre) {
        return chapitreRepo.save(chapitre);
    }
}
