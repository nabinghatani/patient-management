package com.pm.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Entity class representing a Patient in the database.
 * This class is used to persist patient data using JPA (Java Persistence API).
 * It includes fields for the patient's unique ID, name, email, address, date of birth,
 * and registration date, with validation constraints to ensure data integrity.
 */
@Entity
public class Patient {

    /**
     * The unique identifier for the patient, automatically generated as a UUID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    /**
     * The patient's full name. Must not be null.
     */
    @NotNull
    private String name;

    /**
     * The patient's email address. Must be a valid email, non-null, and unique in the database.
     */
    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    /**
     * The patient's residential address. Must not be null.
     */
    @NotNull
    private String address;

    /**
     * The patient's date of birth. Must not be null.
     */
    @NotNull
    private LocalDate dateOfBirth;

    /**
     * The date the patient was registered. Must not be null.
     */
    @NotNull
    private LocalDate registeredDate;

    /**
     * Gets the patient's unique identifier.
     *
     * @return the patient's UUID
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the patient's unique identifier.
     *
     * @param id the UUID to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Gets the patient's name.
     *
     * @return the patient's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the patient's name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the patient's email address.
     *
     * @return the patient's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the patient's email address.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the patient's address.
     *
     * @return the patient's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the patient's address.
     *
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the patient's date of birth.
     *
     * @return the date of birth as a LocalDate
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the patient's date of birth.
     *
     * @param dateOfBirth the date of birth to set
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the patient's registration date.
     *
     * @return the registration date as a LocalDate
     */
    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    /**
     * Sets the patient's registration date.
     *
     * @param registeredDate the registration date to set
     */
    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }
}
