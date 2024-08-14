package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateReason;

    private String diagnosis;

    @ManyToOne
    @Column(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @Column(name = "patient_id")
    private Patient patient;

    @ManyToMany
    @JoinTable(
        name = "recipe_medicine",
        joinColumns = @JoinColumn(name="recipe_id"),
        inverseJoinColumns = @JoinColumn(name="medicine_id"),
        uniqueConstraints = {@UniqueConstraint(columnNames = {"recipe_id", "medicine_id"})}
    )
    private List<Medicine> medicines;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateReason() {
        return dateReason;
    }

    public void setDateReason(Date dateReason) {
        this.dateReason = dateReason;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
}
