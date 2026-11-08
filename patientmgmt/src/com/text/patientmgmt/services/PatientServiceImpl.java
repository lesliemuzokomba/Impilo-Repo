package com.text.patientmgmt.services;

import com.text.patientmgmt.exception.InvalidPatientDataException;
import com.text.patientmgmt.models.Patient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientServiceImpl implements PatientService {

    private final List<Patient> patientRepository = new ArrayList<>();

    @Override
    public Patient createPatient(Patient patient) {
        if (patient == null) {
            throw new InvalidPatientDataException("Patient data cannot be completely empty.");
        }
        if (patient.getName() == null || patient.getName().trim().isEmpty()) {
            throw new InvalidPatientDataException("Patient validation failed: Name is a required field.");
        }
        if (patient.getDateOfBirth() != null && patient.getDateOfBirth().isAfter(LocalDate.now())) {
            throw new InvalidPatientDataException("Patient validation failed: Date of birth cannot be in the future.");
        }

        patientRepository.add(patient);
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patientRepository);
    }

    @Override
    public Optional<Patient> getPatientById(String id) {
        return patientRepository.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst();
    }
}
