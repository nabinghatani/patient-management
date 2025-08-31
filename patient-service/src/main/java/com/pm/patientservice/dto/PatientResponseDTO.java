package com.pm.patientservice.dto;

/**
 * Data Transfer Object (DTO) for sending patient data to the client in API responses.
 * This class represents a simplified view of a patient, excluding sensitive or internal
 * fields like registered date, to be used in responses to client requests.
 */
public class PatientResponseDTO {

    /**
     * The unique identifier of the patient, represented as a string (converted from UUID).
     */
    private String id;

    /**
     * The patient's full name.
     */
    private String name;

    /**
     * The patient's email address.
     */
    private String email;

    /**
     * The patient's residential address.
     */
    private String address;

    /**
     * The patient's date of birth, represented as a string (e.g., "yyyy-MM-dd").
     */
    private String dateOfBirth;

    /**
     * Gets the patient's unique identifier.
     *
     * @return the patient's ID as a string
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the patient's unique identifier.
     *
     * @param id the ID to set as a string
     */
    public void setId(String id) {
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
     * @return the date of birth as a string
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the patient's date of birth.
     *
     * @param dateOfBirth the date of birth to set as a string
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
