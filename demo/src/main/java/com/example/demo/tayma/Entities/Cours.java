package com.example.demo.tayma.Entities;

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



<<<<<<< HEAD:demo/src/main/java/com/example/demo/tayma/Entities/Cours.java
    @OneToMany(mappedBy = "cours")
    private List<Quiz> quizList;
    @OneToMany(mappedBy = "cours")
    private List<Certificat> certificatlist;
    @ManyToMany(mappedBy = "likedCourses")
    Set<User1> likes;
=======
>>>>>>> e944f10b738061c10593560335e716ad80a8456c:demo/src/main/java/com/example/demo/model/Cours.java

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
