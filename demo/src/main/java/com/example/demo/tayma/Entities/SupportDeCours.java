package com.example.demo.tayma.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "supportDeCours")
public class SupportDeCours implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idSQ;

    private String name;

    private String type;


    public SupportDeCours( String name, String type) {

        this.name = name;
        this.type = type;

    }

    public SupportDeCours() {
    }

    public String getIdSQ() {
        return idSQ;
    }

    public void setIdSQ(String idSQ) {
        this.idSQ = idSQ;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
