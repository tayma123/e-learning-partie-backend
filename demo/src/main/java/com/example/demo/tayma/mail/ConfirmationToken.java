package com.example.demo.tayma.mail;


import com.example.demo.tayma.Entities.User1;

import com.example.demo.model.User;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
/*
@Entity
@Table(name="confirmationToken")
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id")
    private long tokenid;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

<<<<<<< HEAD:demo/src/main/java/com/example/demo/tayma/mail/ConfirmationToken.java
    @OneToOne(targetEntity = User1.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private User1 user;
=======
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private User user;
>>>>>>> e944f10b738061c10593560335e716ad80a8456c:demo/src/main/java/com/example/demo/mail/ConfirmationToken.java

    public ConfirmationToken() {
    }

<<<<<<< HEAD:demo/src/main/java/com/example/demo/tayma/mail/ConfirmationToken.java
    public ConfirmationToken(User1 user) {
=======
    public ConfirmationToken(User user) {
>>>>>>> e944f10b738061c10593560335e716ad80a8456c:demo/src/main/java/com/example/demo/mail/ConfirmationToken.java
        this.user = user;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }



    public long getTokenid() {
        return tokenid;
    }

    public void setTokenid(long tokenid) {
        this.tokenid = tokenid;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

<<<<<<< HEAD:demo/src/main/java/com/example/demo/tayma/mail/ConfirmationToken.java
    public User1 getUser() {
        return user;
    }

    public void setUserEntity(User1 user) {
=======
    public User getUser() {
        return user;
    }

    public void setUserEntity(User user) {
>>>>>>> e944f10b738061c10593560335e716ad80a8456c:demo/src/main/java/com/example/demo/mail/ConfirmationToken.java
        this.user = user;
    }
}
*/

