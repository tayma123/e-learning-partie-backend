package com.example.demo.tayma.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
public class Cours implements Serializable {
    @Id
    @GeneratedValue
    private Long idCr;
    private String titre;
    private String description;
   /* @OneToMany(mappedBy = "cours", fetch = FetchType.LAZY)
    private List<Chapitre> chapitres;*/
    @Column(name = "idCt")
    private Long idCt;
    @ManyToOne
    @JoinColumn(name="idCt", insertable = false, updatable = false)
    private Catégorie catégorie;
  /*  @OneToMany(mappedBy = "cours", fetch = FetchType.LAZY)
    private List<ApprenantCourses> inscriptions;*/
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

    public Cours(Long idCr, String titre, String description) {
        this.idCr = idCr;
        this.titre = titre;
        this.description = description;

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

    public Cours() {
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
