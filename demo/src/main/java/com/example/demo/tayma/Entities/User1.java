package com.example.demo.tayma.Entities;


import com.example.demo.tayma.Entities.User1;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
public class User1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String firstName ;
    private String lastName;
    private String email ;
    private String telephone ;
    private String gender ;
    private String userName ;
    private String passWord ;
    private String adress;
    private boolean isEnabled;
    @Enumerated(EnumType.STRING)
    private Role role;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



    public User1() {
    }

    public User1(int id, String firstName, String lastName, String email, String telephone, String gender, String userName, String passWord, String adress, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.gender = gender;
        this.userName = userName;
        this.passWord = passWord;
        this.adress = adress;
        this.role = role;
    }

    public User1(String firstName, String lastName, String email, String telephone, String gender, String userName, String passWord, String adress, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.gender = gender;
        this.userName = userName;
        this.passWord = passWord;
        this.adress = adress;
        this.role = role;
    }

    public User1(String firstName, String lastName, String email, String telephone, String gender, String userName, String passWord, String adress, boolean isEnabled, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.gender = gender;
        this.userName = userName;
        this.passWord = passWord;
        this.adress = adress;
        this.isEnabled = isEnabled;
        this.role = role;
    }
}