package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import java.io.Serializable;

@Entity
public class apprenant implements Serializable {


    private Long id;
    @Id
    private String Nom;
    private String prénom;
    private String age;




}

