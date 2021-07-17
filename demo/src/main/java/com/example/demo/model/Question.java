package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long idQs;
    private String ennoncé;
    private  String Réponse;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idQ")
    private  Quiz quiz;
}
