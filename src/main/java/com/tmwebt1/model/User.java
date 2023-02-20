package com.tmwebt1.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity(name = "TELEMED_USER")
public class User {
    // 0-patient 1-admin
    int type = 0;
    @Id
    @GeneratedValue()
    Long id;
    private String mbo;
    private String firstName;
    private String lastName;
  //  @DateTimeFormat(pattern = "dd-MM-yyyy")
  //  private Date birthDate;
    private String phone;
    private String email;
    private String password;
    public User() {
        super();
    }

    public User(String firstName, String lastName, String phone, String email, String password, String mbo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.password = password;
        this.mbo = mbo;
        this.email = email;
    }



    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

   /* public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }*/

    public int getType () {
        return type;
    }

    public void setType (int type) {
        this.type = type;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMbo () {
        return mbo;
    }

    public void setMbo (String mbo) {
        this.mbo = mbo;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public Long getId () {
        return id;
    }
}