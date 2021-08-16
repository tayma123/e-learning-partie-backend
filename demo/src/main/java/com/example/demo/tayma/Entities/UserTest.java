package com.example.demo.tayma.Entities;

import com.example.demo.tayma.Entities.Role;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data

public class UserTest {

    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String gender;
    private String userName;
    private String passWord;
    private String adress;
    private Boolean isEnabled;
    @Enumerated(EnumType.STRING)
    private Role role;

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

    public com.example.demo.tayma.Entities.Role getRole() {
        return role;
    }

    public void setRole(com.example.demo.tayma.Entities.Role role) {
        this.role = role;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public UserTest() {
    }

    public UserTest(String firstName, String lastName, String email, String telephone, String gender, String userName, String passWord, String adress, Role role) {
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

    public UserTest(String firstName, String lastName, String email, String telephone, String gender, String userName, String passWord, String adress, Boolean isEnabled, Role role) {
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
