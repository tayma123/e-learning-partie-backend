package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOpt;
    private  String opt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idQs")
    private Question question;

    @Column(name = "is_correct", columnDefinition = "boolean default false")
    private Boolean isCorrect;
    @Column(name = "option")
    private Character option;

    public Long getIdOpt() {
        return idOpt;
    }

    public void setIdOpt(Long idOpt) {
        this.idOpt = idOpt;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public Character getOption() {
        return option;
    }

    public void setOption(Character option) {
        this.option = option;
    }
}

