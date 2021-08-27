package com.example.demo.tayma.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="cours")
public class Cours implements Serializable {
    @Id
    @GeneratedValue
    private Long idCr;
    private String titre;
    private String description;
    @Column(name = "idCt")
    private Long idCt;
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="idCt", insertable = false, updatable = false)
    private Catégorie catégorie;
    @Column(name = "userName")
    private String userName;
    public Long getIdCr() {
        return idCr;
    }
    public void setIdCr(Long idCr) {
        this.idCr = idCr;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getIdCt() {
        return idCt;
    }
    public void setIdCt(Long idCt) {
        this.idCt = idCt;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Cours(Long idCr, String titre, String description) {
        this.idCr = idCr;
        this.titre = titre;
        this.description = description;

    }

    public Cours() {
    }

    public Cours(Long idCr, String titre, String description, Long idCt, String userName) {
        this.idCr = idCr;
        this.titre = titre;
        this.description = description;
        this.idCt = idCt;
        this.userName = userName;
    }
/*
    public List<Chapitre> getChapitres() {
        return chapitres;
    }

    public void setChapitres(List<Chapitre> chapitres) {
        this.chapitres = chapitres;
    }

    public void addChapitre(Chapitre chapitre) {
        if (chapitres.contains(chapitre))
            return;

        chapitres.add(chapitre);
    }*/

    /*public List<ApprenantCourses> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<ApprenantCourses> inscriptions) {
        this.inscriptions = inscriptions;
    }
    public void addInscription(ApprenantCourses apprenantCourse) {
        if (inscriptions.contains(apprenantCourse))
            return;

        inscriptions.add(apprenantCourse);
    }*/

}
