package com.pm.patientservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler to manage application-wide exceptions in a consistent manner.
 * <p>
 * This class uses @ControllerAdvice to intercept exceptions thrown by controllers
 * and provide meaningful HTTP responses to the client.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles validation errors thrown when @Valid or @Validated fails.
     *
     * @param ex the MethodArgumentNotValidException thrown by Spring
     * @return a ResponseEntity containing a map of field errors and HTTP status 400 (Bad Request)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * Handles EmailAlreadyExistsException when a user tries to register with an existing email.
     *
     * @param ex the EmailAlreadyExistsException
     * @return a ResponseEntity with an error message and HTTP status 400 (Bad Request)
     */
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExists(EmailAlreadyExistsException ex) {
        log.warn("Email Already Exists: {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Email address already exists.");
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * Handles PatientNotFoundException when a requested patient cannot be found in the system.
     *
     * @param ex the PatientNotFoundException
     * @return a ResponseEntity with an error message and HTTP status 404 (Not Found)
     */
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePatientNotFound(PatientNotFoundException ex) {
        log.warn("Patient not found: {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Patient not found.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }
}

