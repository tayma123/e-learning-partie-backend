package com.example.demo.model;

import com.example.demo.model.Role;

public class UserRegistrationDto {

    private String username;
    private String password;
    private String dateNaissance;
    private String nom;
    private String prenom;
    private Role role;



    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String username, String password, String dateNaissance, String nom, String prenom, Role role) {
        this.username = username;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
