package com.pm.patientservice.exception;

/**
 * Custom exception thrown when a requested Patient entity
 * is not found in the system (e.g., by ID).
 * <p>
 * This is an unchecked exception (extends RuntimeException),
 * so it does not require explicit try-catch blocks.
 */
public class PatientNotFoundException extends RuntimeException {

    /**
     * Constructs a new PatientNotFoundException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public PatientNotFoundException(String message) {
        super(message);
    }
}
