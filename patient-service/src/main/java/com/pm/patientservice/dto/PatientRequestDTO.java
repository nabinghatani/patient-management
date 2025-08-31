package com.pm.patientservice.dto;

import com.pm.patientservice.dto.validators.CreatePatientValidationGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Data Transfer Object (DTO) for receiving patient data from client requests.
 * This class is used to capture and validate patient information sent via API requests,
 * such as creating or updating a patient. It includes fields for name, email, address,
 * date of birth, and registered date, with validation constraints to ensure data integrity.
 */
public class PatientRequestDTO {

    /**
     * The patient's full name. Must not be blank and cannot exceed 100 characters.
     */
    @NotBlank(message = "Name is required.")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    @Schema(description = "Patient's full name")
    private String name;

    /**
     * The patient's email address. Must be a valid email format and cannot be blank.
     */
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    /**
     * The patient's residential address. Must not be blank.
     */
    @NotBlank(message = "Address is required")
    private String address;

    /**
     * The patient's date of birth in string format (e.g., "yyyy-MM-dd").
     * Must not be blank.
     */
    @NotBlank(message = "Date of birth is required")
    private String dateOfBirth;

    /**
     * The date the patient was registered in string format (e.g., "yyyy-MM-dd").
     * Must not be blank.
     */
    @NotBlank(groups = CreatePatientValidationGroup.class, message = "Registered date is required")
    private String registeredDate;

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
     * @return the date of birth in string format
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the patient's date of birth.
     *
     * @param dateOfBirth the date of birth to set in string format
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the patient's registered date.
     *
     * @return the registered date in string format
     */
    public String getRegisteredDate() {
        return registeredDate;
    }

    /**
     * Sets the patient's registered date.
     *
     * @param registeredDate the registered date to set in string format
     */
    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }
}