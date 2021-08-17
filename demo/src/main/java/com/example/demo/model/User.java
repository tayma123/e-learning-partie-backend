package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    private String username;
    private String password;
    private String dateNaissance;
    private String nom;
    private String prenom;

    private boolean isEnabled;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ApprenantCourses> Inscriptions;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Cours> CoursEnseignant;
  /*  @ManyToMany
    @JoinTable(
            name = "user_courses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id"))
    Set<Cours> UserCourses;*/
    public User() {
    }

    public User(Long id, String username, String password, String dateNaissance, String nom, String prenom, Boolean isEnabled, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.nom = nom;
        this.prenom = prenom;
        this.isEnabled =isEnabled;
        this.role = role;
    }

    public User(String username, String password, String dateNaissance, String nom, String prenom, Role role) {
        this.username = username;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public User(String username, String password, Boolean isEnabled) {
        this.username = username;
        this.password = password;
        this.isEnabled = isEnabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

  /*  public Set<Cours> getUserCourses() {
        return UserCourses;
    }

    public void setUserCourses(Set<Cours> userCourses) {
        UserCourses = userCourses;
    }*/

    public List<Cours> getCoursEnseignant() {
        return CoursEnseignant;
    }

    public void setCoursEnseignant(List<Cours> coursEnseignant) {
        CoursEnseignant = coursEnseignant;
    }

    public void addCours(Cours cours) {
        if (CoursEnseignant.contains(cours))
            return;

        CoursEnseignant.add(cours);
    }
}

