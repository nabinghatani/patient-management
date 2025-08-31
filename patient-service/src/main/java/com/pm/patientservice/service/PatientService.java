package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.exception.PatientNotFoundException;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service // Marks this class as a Spring service so it can be injected into controllers
public class PatientService {

    private final PatientRepository patientRepository;

    // Constructor-based dependency injection
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    /**
     *
     * @param id
     * @return
     */
    public PatientResponseDTO getPatientById(UUID id) {
        var patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(
                        "Patient not found with ID: " + id));
        return PatientMapper.toPatientResponseDTO(patient);
    }

    /**
     * Fetch all patients from the database.
     * Maps each Patient entity to a PatientResponseDTO.
     *
     * @return List of PatientResponseDTO
     */
    public List<PatientResponseDTO> getPatients() {
        var patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::toPatientResponseDTO)
                .toList();
    }

    /**
     * Create a new patient.
     * Checks if a patient with the same email already exists.
     *
     * @param patientRequestDTO Patient data from client
     * @return PatientResponseDTO of the newly created patient
     * @throws EmailAlreadyExistsException if email already exists
     */
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        // Check if email already exists
        if (!patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException(
                    "A patient with this email already exists " + patientRequestDTO.getEmail()
            );
        }
        // Convert DTO to entity, save it, and return response DTO
        var patient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toPatientResponseDTO(patient);
    }

    /**
     * Update an existing patient.
     * Checks if patient exists and ensures email uniqueness.
     *
     * @param id Patient ID to update
     * @param patientRequestDTO New patient data
     * @return Updated PatientResponseDTO
     * @throws PatientNotFoundException if patient not found
     * @throws EmailAlreadyExistsException if new email is already used by another patient
     */
    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO) {
        var patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(
                        "Patient not found with ID: " + id
                ));
        // Check if email is already used by another patient
        if (patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(), id)) {
            throw new EmailAlreadyExistsException(
                    "A patient with this email already exists " + patientRequestDTO.getEmail()
            );
        }
        // Update patient fields
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        var updatedPatient = patientRepository.save(patient);
        return PatientMapper.toPatientResponseDTO(updatedPatient);
    }

    /**
     * Delete a patient by ID.
     *
     * @param id Patient ID to delete
     */
    public void deletePatient(UUID id) {
        patientRepository.deleteById(id);
    }
}

