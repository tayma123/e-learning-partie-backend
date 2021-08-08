package com.example.demo.tayma.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Answer implements Serializable {
    @Id
    @GeneratedValue
    private Long idAnswer;
    private String answerText;
    private Boolean isCorrect;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idQs")
    private  Question question;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idAnswerQ")
    private  QuizAnswer quizAnswer;
    public Answer() {
    }

    public Answer(Long idAnswer, String answerText, Boolean isCorrect, Question question) {
        this.idAnswer = idAnswer;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
        this.question = question;
    }

    public Long getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Long idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public QuizAnswer getQuizAnswer() {
        return quizAnswer;
    }

    public void setQuizAnswer(QuizAnswer quizAnswer) {
        this.quizAnswer = quizAnswer;
    }
}
