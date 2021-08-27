package com.example.demo.tayma.Repository;


import com.example.demo.tayma.Entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface CoursRepo extends JpaRepository<Cours,Long> {

    @Modifying
    @Query("delete from Cours where idCr=?1")
    void deleteCoursById(Long idCr);

    Optional<Cours> findCoursByIdCr(Long idCr);

    Optional<Set<Cours>> findCoursByCatégorie(Long idCt);

    Optional<Set<Cours>> findCoursByUserName(String userName);

    Optional<Cours> findCoursByTitre(String titre);



    @Modifying
    @Query("delete from Cours where Name=?1")
    void deleteCoursByName(String Name);
}
