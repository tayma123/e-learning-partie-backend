package com.example.demo.tayma.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQs;
    private String question;
    @Column(name = "idQ")
    private Long idQ;
    @ManyToOne
    @JoinColumn(name = "idQ", insertable = false, updatable = false)
    private Quiz quiz;
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Options> optionsList;

    public Question() {
    }

    public Question(Long idQs, String question) {
        this.idQs = idQs;
        this.question = question;

    }
/*
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }*/

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


    public List<Options> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List<Options> optionsList) {
        this.optionsList = optionsList;
    }
    public void addOption(Options option) {
        if (optionsList.contains(option))
            return;

        optionsList.add(option);
    }

    public Long getIdQ() {
        return idQ;
    }

    public void setIdQ(Long idQ) {
        this.idQ = idQ;
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQs=" + idQs +
                ", question='" + question + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question1 = (Question) o;
        return Objects.equals(getIdQs(), question1.getIdQs()) && Objects.equals(getQuestion(), question1.getQuestion()) && Objects.equals(getIdQ(), question1.getIdQ()) && Objects.equals(quiz, question1.quiz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdQs(), getQuestion(), getIdQ(), quiz);
    }
}
