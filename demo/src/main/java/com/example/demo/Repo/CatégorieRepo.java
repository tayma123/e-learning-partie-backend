package com.example.demo.Repo;

import com.example.demo.model.Catégorie;
import com.example.demo.model.Cours;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CatégorieRepo  extends JpaRepository<Catégorie,String> {

    void deleteCatégorieByIdCt(Long idCt);



    Optional<Catégorie> findCatégorieByIdCt(Long idCt);
    @Modifying
    @Query("delete from Cours where Name=?1")
    void deleteCatégorieByNomC(String NomC);


    Optional<Catégorie> findCatégorieByNomC(String NomC);
}
