package com.example.demo.tayma.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Cours implements Serializable {
    @Id
    @GeneratedValue
    private Long idCr;
    private String titre;
    private String description;
    @OneToMany(mappedBy = "cours", fetch = FetchType.LAZY)
    private List<Chapitre> chapitres;
    @Column(name = "idCt")
    private Long idCt;
    @ManyToOne
    @JoinColumn(name="idCt", insertable = false, updatable = false)
    private Catégorie catégorie;
    @OneToMany(mappedBy = "cours", fetch = FetchType.LAZY)
    private List<ApprenantCourses> inscriptions;
    @Column(name = "username")
    private String username;
    @ManyToOne
    @JoinColumn(name = "username", insertable = false, updatable = false)
    private User user;




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

    public Cours(Long idCr, String titre, String description, List<Chapitre> chapitres) {
        this.idCr = idCr;
        this.titre = titre;
        this.description = description;
        this.chapitres = chapitres;
    }

    public void setIdCt(Long idCt) {
        this.idCt = idCt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Cours() {
    }


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
    }

    public List<ApprenantCourses> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<ApprenantCourses> inscriptions) {
        this.inscriptions = inscriptions;
    }
    public void addInscription(ApprenantCourses apprenantCourse) {
        if (inscriptions.contains(apprenantCourse))
            return;

        inscriptions.add(apprenantCourse);
    }

}
