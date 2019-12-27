package com.example.turnstile.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Card {
    @Id
    @GeneratedValue
    private Integer id;

    private Date expirationDate;

    private Integer passCount;

    @OneToOne
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getPassCount() {
        return passCount;
    }

    public void setPassCount(Integer passCount) {
        this.passCount = passCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
