package com.example.demo.tayma.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ApprenantCourses implements Serializable {
    @Id
    @GeneratedValue
    private Long idAC;
    @Column(name = "idCr")
    private Long idCr;
    @ManyToOne
    @JoinColumn(name = "idCr", insertable = false, updatable = false)
    private Cours cours;
    @Column(name = "username")
    private String username;
    @ManyToOne
    @JoinColumn(name = "username", insertable = false, updatable = false)
    private User user;

    public ApprenantCourses() {
    }

    public ApprenantCourses(Long idAC, Long idCr, String username) {
        this.idAC = idAC;
        this.idCr = idCr;
        this.username = username;
    }

    public Long getIdAC() {
        return idAC;
    }

    public void setIdAC(Long idAC) {
        this.idAC = idAC;
    }

    public Long getIdCr() {
        return idCr;
    }

    public void setIdCr(Long idCr) {
        this.idCr = idCr;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
