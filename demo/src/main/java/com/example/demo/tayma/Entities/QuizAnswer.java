package com.example.demo.tayma.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class QuizAnswer implements Serializable {
    @Id
    @GeneratedValue
    private Long idAnswerQ;
    @OneToMany(mappedBy = "quizAnswer")
    private List<Answer> answerList;
    private Long score;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idQ")
    private  Quiz quiz;

    public QuizAnswer() {
    }

    public QuizAnswer(Long idAnswerQ, List<Answer> answerList, Long score, Quiz quiz) {
        this.idAnswerQ = idAnswerQ;
        this.answerList = answerList;
        this.score = score;
        this.quiz = quiz;
    }

    public Long getIdAnswerQ() {
        return idAnswerQ;
    }

    public void setIdAnswerQ(Long idAnswerQ) {
        this.idAnswerQ = idAnswerQ;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
