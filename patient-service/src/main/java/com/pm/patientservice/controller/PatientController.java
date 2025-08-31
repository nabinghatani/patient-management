package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.dto.validators.CreatePatientValidationGroup;
import com.pm.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController // Marking this class as a REST controller
@RequestMapping("/patients") // Base path for all endpoints in this controller
@Tag(name = "Patient APIs", description = "API for managing Patients") // Swagger/OpenAPI tag for grouping endpoints
public class PatientController {

    private final PatientService patientService; // Injecting service for business logic

    // Constructor-based dependency injection
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * Get patient by ID.
     *
     * @return PatientResponseDTO wrapped in ResponseEntity
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get patient by ID") // Swagger summary
    public ResponseEntity<PatientResponseDTO> getPatient(@PathVariable UUID id) {
        var patient = patientService.getPatientById(id); // Fetching patient by ID
        return ResponseEntity.ok().body(patient); // Returning 200 OK with a patient
    }

    /**
     * Get all patients.
     *
     * @return List of PatientResponseDTO wrapped in ResponseEntity
     */
    @GetMapping
    @Operation(summary = "Get all patients") // Swagger summary
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        var patients = patientService.getPatients(); // Fetching all patients
        return ResponseEntity.ok().body(patients); // Returning 200 OK with a patient list
    }

    /**
     * Create a new patient.
     * Uses validation groups to apply specific validation rules for creation.
     *
     * @param requestDTO PatientRequestDTO from a client
     * @return Created PatientResponseDTO
     */
    @PostMapping
    @Operation(summary = "Create a new Patient")
    public ResponseEntity<PatientResponseDTO> createPatient(
            @Validated({Default.class, CreatePatientValidationGroup.class}) // Applying validation groups
            @RequestBody PatientRequestDTO requestDTO) {

        var patient = patientService.createPatient(requestDTO); // Creating patient
        return ResponseEntity.ok().body(patient); // Returning created patient
    }

    /**
     * Update an existing patient.
     *
     * @param id Patient ID
     * @param requestDTO PatientRequestDTO from client
     * @return Updated PatientResponseDTO
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update existing Patient")
    public ResponseEntity<PatientResponseDTO> updatePatient(
            @PathVariable UUID id,
            @Validated(Default.class) // Applying default validation rules
            @RequestBody PatientRequestDTO requestDTO) {

        var patient = patientService.updatePatient(id, requestDTO); // Updating patient
        return ResponseEntity.ok().body(patient); // Returning updated patient
    }

    /**
     * Delete a patient by ID.
     *
     * @param id Patient ID
     * @return No content (204)
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Patient")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        patientService.deletePatient(id); // Deleting patient
        return ResponseEntity.noContent().build(); // Returning 204 No Content
    }
}
