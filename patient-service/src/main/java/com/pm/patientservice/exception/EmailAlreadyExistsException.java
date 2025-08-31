package com.pm.patientservice.exception;

/**
 * Custom exception thrown when attempting to create or register
 * a user with an email that already exists in the system.
 * <p>
 * This is an unchecked exception (extends RuntimeException),
 * so it does not require explicit try-catch blocks.
 */
public class EmailAlreadyExistsException extends RuntimeException {

    /**
     * Constructs a new EmailAlreadyExistsException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}

