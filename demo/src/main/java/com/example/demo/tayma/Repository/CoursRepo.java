package com.example.demo.tayma.Repository;


<<<<<<< HEAD:demo/src/main/java/com/example/demo/tayma/Repository/CoursRepo.java
import com.example.demo.tayma.Entities.Cours;
=======
import com.example.demo.model.Cours;
>>>>>>> e944f10b738061c10593560335e716ad80a8456c:demo/src/main/java/com/example/demo/Repo/CoursRepo.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CoursRepo extends JpaRepository<Cours,Long> {


    void deleteCoursByIdCr(Long id);



    Optional<Cours> findCoursByIdCr(Long idCr);
    @Modifying
    @Query("delete from Cours where Name=?1")
    void deleteCoursByName(String Name);


    Optional<Cours> findCoursByTitre(String titre);

    Set<Cours> findByCatégorie(Long idCt);}
