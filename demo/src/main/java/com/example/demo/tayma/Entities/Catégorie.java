package com.example.demo.tayma.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class    Catégorie implements Serializable {
    @Id
    @GeneratedValue
    private Long idCt;
    private String nomC;

    @OneToMany(mappedBy = "catégorie", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Set<Cours> coursList;
    public Catégorie() { }

    public Catégorie(Long idCt, String nomC, Set<Cours> coursList) {
        this.idCt = idCt;
        this.nomC = nomC;
        this.coursList = coursList; }

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

    public Set<Cours> getCoursList() {
        return coursList;
    }
    public void setCoursList(Set<Cours> coursList) {
        this.coursList = coursList;
    }

    public void addCours(Cours cours) {
        if (coursList.contains(cours))
            return;

        coursList.add(cours);
    }
}
