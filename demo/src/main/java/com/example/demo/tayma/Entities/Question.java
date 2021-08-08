package com.example.demo.tayma.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQs;
    private String question;
    private String response1;
    private String response2;
    private String response3;
    private String correct;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idQ")
    private  Quiz quiz;

    public Question() {
    }

    public Question(Long idQs, String question, String response1, String response2, String response3, String correct) {
        this.idQs = idQs;
        this.question = question;
        this.response1 = response1;
        this.response2 = response2;
        this.response3 = response3;
        this.correct = correct;
    }

    public Long getIdQs() {
        return idQs;
    }

    public void setIdQs(Long idQs) {
        this.idQs = idQs;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponse1() {
        return response1;
    }

    public void setResponse1(String response1) {
        this.response1 = response1;
    }

    public String getResponse2() {
        return response2;
    }

    public void setResponse2(String response2) {
        this.response2 = response2;
    }

    public String getResponse3() {
        return response3;
    }

    public void setResponse3(String response3) {
        this.response3 = response3;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQs=" + idQs +
                ", question='" + question + '\'' +
                ", response1='" + response1 + '\'' +
                ", response2='" + response2 + '\'' +
                ", response3='" + response3 + '\'' +
                ", correct='" + correct + '\'' +
                ", quiz=" + quiz +
                '}';
    }
}
