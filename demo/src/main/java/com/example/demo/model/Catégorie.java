package com.example.demo.model;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Catégorie implements Serializable {
    @Id
    @GeneratedValue
    private Long idCt;
    private String nomC;

    @OneToMany(mappedBy = "catégorie", fetch = FetchType.EAGER)
    private Set<Cours> coursList;
    public Catégorie() {

    }

    public Catégorie(Long idCt, String nomC, Set<Cours> coursList) {
        this.idCt = idCt;
        this.nomC = nomC;
        this.coursList = coursList;
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
