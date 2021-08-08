package com.example.demo.tayma.Entities;

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

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
