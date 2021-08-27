package com.example.demo.tayma.Entities;

import javax.persistence.*;

@Entity
public class Certificat {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idCr")
    private  Cours cours;
    private String intitulé;
    public Certificat(Cours cours, String intitulé) {
        this.cours = cours;
        this.intitulé = intitulé;
    }
    public Certificat(Long id, Cours cours, String intitulé) {
        this.id = id;
        this.cours = cours;
        this.intitulé = intitulé;
    }
    public Certificat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public String getIntitulé() {
        return intitulé;
    }

    public void setIntitulé(String intitulé) {
        this.intitulé = intitulé;
    }
}
