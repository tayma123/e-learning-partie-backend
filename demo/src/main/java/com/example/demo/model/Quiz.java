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
    private boolean isPassedByUser;
    private int score;
    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY)
    private List<Question> questions;
    @Column(name = "idChap")
    private Long idChap;
    @OneToOne
    @JoinColumn(name="idChap", insertable = false, updatable = false)
    private Chapitre chapitre;



    public Quiz() {
    }

    public Quiz( String intutilé, String description) {

        this.intutilé = intutilé;
        this.description = description;
    }

    public Quiz(Long idQ, String intutilé, String description, boolean isPassedByUser, int score, List<Question> questions) {
        this.idQ = idQ;
        this.intutilé = intutilé;
        this.description = description;
        this.isPassedByUser = isPassedByUser;
        this.score = score;
        this.questions = questions;
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public boolean isPassedByUser() {
        return isPassedByUser;
    }

    public void setPassedByUser(boolean passedByUser) {
        isPassedByUser = passedByUser;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addQuestion(Question question) {
        if (questions.contains(question))
            return;

        questions.add(question);
    }


    public Long getIdChap() {
        return idChap;
    }

    public void setIdChap(Long idChap) {
        this.idChap = idChap;
    }
}
