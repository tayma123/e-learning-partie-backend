package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQs;
    private String question;

    @OneToMany(mappedBy = "question")
    private List<Options> optionsList;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idQ")
    private  Quiz quiz;

    public Question() {
    }

    public Question(Long idQs, String question) {
        this.idQs = idQs;
        this.question = question;

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


    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Options> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List<Options> optionsList) {
        this.optionsList = optionsList;
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQs=" + idQs +
                ", question='" + question + '\'' +
                ", quiz=" + quiz +
                '}';
    }
}
