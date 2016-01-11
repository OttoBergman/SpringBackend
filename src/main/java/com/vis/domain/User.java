package com.vis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by otto on 2016-01-10.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public User() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
