package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
@Entity
public class Catégorie implements Serializable {
    @Id
    @GeneratedValue
    private Long idCt;
    private String nomC;
    @OneToMany(mappedBy = "catégorie")
    private List<Cours> cours;

    public Catégorie() {

    }

    public Catégorie(Long idCt, String nomC, List<Cours> cours) {
        this.idCt = idCt;
        this.nomC = nomC;
        this.cours = cours;
    }

    public Catégorie(Long idCt, String nomC) {
        this.idCt = idCt;
        this.nomC = nomC;
    }

    public Long getIdCt() {
        return idCt;
    }

    public void setIdCt(Long idCt) {
        this.idCt = idCt;
    }

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }
}
