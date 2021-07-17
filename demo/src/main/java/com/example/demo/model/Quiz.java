package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Quiz implements Serializable {
    @Id
    @GeneratedValue
    private Long idQ;
    private String intutilé;
    private  String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idCr")
    private  Cours cours;

    @OneToMany(mappedBy = "quiz")
    private List<Question> questionList;
    public Quiz() {
    }

    public Quiz(Long idQ, String intutilé, String description) {
        this.idQ = idQ;
        this.intutilé = intutilé;
        this.description = description;
    }

    public Long getIdQ() {
        return idQ;
    }

    public void setIdQ(Long idQ) {
        this.idQ = idQ;
    }

    public String getIntutilé() {
        return intutilé;
    }

    public void setIntutilé(String intutilé) {
        this.intutilé = intutilé;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
