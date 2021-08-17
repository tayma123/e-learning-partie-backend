package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOpt;
    private  String opt;
    @Column(name = "is_correct", columnDefinition = "boolean default false")
    private Boolean isCorrect;
    @Column(name = "idQs")
    private Long idQs;
    @ManyToOne
    @JoinColumn(name = "idQs", insertable = false, updatable = false)
    private Question question;
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


    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public Long getIdQs() {
        return idQs;
    }

    public void setIdQs(Long idQs) {
        this.idQs = idQs;
    }
}

