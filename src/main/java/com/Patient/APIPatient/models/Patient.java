package com.Patient.APIPatient.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //speichert Einträge in der DB
public class Patient {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String name;
    private String zimNum;

    public Patient() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZimNum() {
        return zimNum;
    }

    public void setZimNum(String zimNum) {
        this.zimNum = zimNum;
    }
}
