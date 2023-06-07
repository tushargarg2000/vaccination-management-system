package com.example.vaccineManagement.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "dose1")
public class Dose1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Primary Key

    @Column(unique = true)
    private String doseId; //Unique

    @CreationTimestamp
    private Date vaccinationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoseId() {
        return doseId;
    }

    public void setDoseId(String doseId) {
        this.doseId = doseId;
    }

    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(Date creationDate) {
        this.vaccinationDate = creationDate;
    }
}
