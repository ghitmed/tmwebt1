package com.tmwebt1.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class RecordTelemed {
    @Id
    @GeneratedValue
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTimeInput;
    private int systolic;
    private int diastolic;
    private int heartB;
    private String healthStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")

    private User user;
    public RecordTelemed() {
        super();
    }
    public RecordTelemed(Date dateTimeInput, int systolic, int diastolic, int heartB, String healthStatus) {
        this.dateTimeInput = dateTimeInput;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heartB = heartB;
        this.healthStatus = healthStatus;
    }

    public User getUser () {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }

    public Long getId () {
        return id;
    }
    public Date getDateTimeInput() {
        return dateTimeInput;
    }

    public void setDateTimeInput(Date dateTimeInput) {
        this.dateTimeInput = dateTimeInput;
    }

    public int getSystolic () {
        return systolic;
    }

    public void setSystolic (int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic () {
        return diastolic;
    }

    public void setDiastolic (int diastolic) {
        this.diastolic = diastolic;
    }

    public int getHeartB() {
        return heartB;
    }

    public void setHeartB(int heartB) {
        this.heartB = heartB;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

}