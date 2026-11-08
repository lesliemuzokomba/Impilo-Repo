package com.text.patientmgmt.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Patient {
    private final String id;
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String contactNumber;
    private boolean isActive;

    public Patient(String name, LocalDate dateOfBirth, Gender gender, String contactNumber) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.isActive = true;
    }

    public int getAge() {
        if (this.dateOfBirth == null) return 0;
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public String getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    @Override
    public String toString() {
        return String.format("Patient [ID: %s | Name: %s | Age: %d | Gender: %s | Phone: %s | Status: %s]",
                id, name, getAge(), gender, contactNumber, isActive ? "Active" : "Archived");
    }
}
