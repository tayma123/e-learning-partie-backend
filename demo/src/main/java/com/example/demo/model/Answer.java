package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Answer implements Serializable {
    @Id
    @GeneratedValue
    private Long idAnswer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idQs")
    private  Question question;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idQ")
    private  Quiz quiz;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offeredAnswerId")
    private Options option;
    public Answer() {
    }

    public Answer(Long idAnswer, Question question, User user, Options option) {
        this.idAnswer = idAnswer;
        this.question = question;
        this.quiz = question.getQuiz();
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
        return question.getQuiz();
    }

    public void setQuiz() {
        this.quiz = this.question.getQuiz();
    }
}
