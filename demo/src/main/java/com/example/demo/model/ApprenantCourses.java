package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ApprenantCourses implements Serializable {
    @Id
    @GeneratedValue
    private Long idAC;
    @Column(name = "username")
    private String username;
    @ManyToOne
    @JoinColumn(name = "username", insertable = false, updatable = false)
    private User user;
    @Column(name = "idCr")
    private Long idCr;
    @ManyToOne
    @JoinColumn(name = "username", insertable = false, updatable = false)
    private Cours cours;

    public ApprenantCourses() {
    }

    public ApprenantCourses(Long idAC, String username,  Long idCr) {
        this.idAC = idAC;
        this.username = username;
        this.idCr = idCr;
    }

    public Long getIdAC() {
        return idAC;
    }

    public void setIdAC(Long idAC) {
        this.idAC = idAC;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getIdCr() {
        return idCr;
    }

    public void setIdCr(Long idCr) {
        this.idCr = idCr;
    }
}
