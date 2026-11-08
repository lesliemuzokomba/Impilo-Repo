package com.text.patientmgmt.services;

import com.text.patientmgmt.models.Patient;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient createPatient(Patient patient);
    List<Patient> getAllPatients();
    Optional<Patient> getPatientById(String id);
}
