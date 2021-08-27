package com.example.demo.tayma.Repository;

import com.example.demo.tayma.Entities.Catégorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CatégorieRepo  extends JpaRepository<Catégorie,Long> {

    void deleteCatégorieByIdCt(Long idCt);

    Optional<Catégorie> findCatégorieByIdCt(Long idCt);
    @Modifying
    @Query("delete from Catégorie where NomC=?1")
    void deleteCatégorieByNomC(String NomC);

    Optional<Catégorie> findCatégorieByNomC(String NomC);
}
