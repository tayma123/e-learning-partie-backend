package com.example.demo.tayma.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Answer implements Serializable {
    @Id
    @GeneratedValue
    private Long idAnswer;
    @Column(name = "idQs")
    private Long idQs;
    @ManyToOne
    @JoinColumn(name="idQs", insertable = false, updatable = false)
    private Question question;
    @ManyToOne
    @JoinColumn(name="idQ", insertable = false, updatable = false)
    private Quiz quiz;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "idOpt", insertable = false, updatable = false)
    private Options option;
    public Answer() {
    }

    public Answer(Long idAnswer, Question question, Quiz quiz,User user, Options option) {
        this.idAnswer = idAnswer;
        this.question = question;
        this.quiz = quiz;
        this.user = user;
        this.option = option;
    }

    public Long getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Long idAnswer) {
        this.idAnswer = idAnswer;
    }


    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Options getOption() {
        return option;
    }

    public void setOption(Options option) {
        this.option = option;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz() {
        this.quiz = quiz;
    }
}
