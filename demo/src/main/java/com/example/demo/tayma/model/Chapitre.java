package com.example.demo.tayma.model;

import javax.persistence.*;

@Entity
public class Chapitre {
    @Id
    @GeneratedValue
    private Long idChap;
    private String titreChap;
    private String description;
    @Column(name = "idCr")
    private Long idCr;

    @ManyToOne
    @JoinColumn(name="idCr", insertable = false, updatable = false)
    private Cours cours;
    @OneToOne(mappedBy = "chapitre", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Quiz quiz;

    public Chapitre() {
    }

    public Chapitre(Long idChap, String titreChap, String description, Long idCr,Quiz quiz) {
        this.idChap = idChap;
        this.titreChap = titreChap;
        this.description = description;
        this.idCr = idCr;

        this.quiz = quiz;
    }

    public Chapitre(Long idChap, String titreChap, String description) {
        this.idChap = idChap;
        this.titreChap = titreChap;
        this.description = description;

    }

    public Long getIdCr() {
        return idCr;
    }

    public void setIdCr(Long idCr) {
        this.idCr = idCr;
    }


    public Long getIdChap() {
        return idChap;
    }

    public void setIdChap(Long idChap) {
        this.idChap = idChap;
    }

    public String getTitreChap() {
        return titreChap;
    }

    public void setTitreChap(String titreChap) {
        this.titreChap = titreChap;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  public Quiz getQuiz() {
        return quiz;
    }
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    }



