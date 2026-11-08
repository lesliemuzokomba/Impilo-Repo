package com.text.patientmgmt;

import com.text.patientmgmt.exception.InvalidPatientDataException;
import com.text.patientmgmt.models.Gender;
import com.text.patientmgmt.models.Patient;
import com.text.patientmgmt.services.PatientService;
import com.text.patientmgmt.services.PatientServiceImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PatientService patientService = new PatientServiceImpl();

        System.out.println("=== Initializing Patient Registration Records ===");

        try {
            Patient p1 = new Patient("Leslie Muzokomba", LocalDate.of(2005, 5, 14), Gender.MALE, "+263-771-000-111");
            Patient p2 = new Patient("Thomas Muzokomba", LocalDate.of(2006, 11, 23), Gender.FEMALE, "+263-712-222-333");
            Patient p3 = new Patient("Winnet Muzuka", LocalDate.of(2010, 2, 2), Gender.OTHER, "+1-555-019-2834");

            Patient savedP1 = patientService.createPatient(p1);
            Patient savedP2 = patientService.createPatient(p2);
            patientService.createPatient(p3);

            System.out.println("✔ Successfully registered: " + savedP1.getName() + " with System ID: " + savedP1.getId());
            System.out.println("✔ Successfully registered: " + savedP2.getName() + " with System ID: " + savedP2.getId());

        } catch (InvalidPatientDataException e) {
            System.err.println("Unexpected Error initializing dummy sets: " + e.getMessage());
        }

        System.out.println("\n=== Retrieving Total Active Patients ===");
        patientService.getAllPatients().forEach(patient -> System.out.println(patient));


        System.out.println("\n=== Triggering Business Logic Validations (Expect Errors) ===");
        try {
            Patient invalidPatient = new Patient("Baby Tomorrow", LocalDate.of(2028, 1, 1), Gender.UNKNOWN, "000");
            patientService.createPatient(invalidPatient);
        } catch (InvalidPatientDataException e) {
            System.out.println("❌ Validation Blocked Entry: " + e.getMessage());
        }

        try {
            Patient invalidPatient2 = new Patient("   ", LocalDate.of(1990, 1, 1), Gender.FEMALE, "111");
            patientService.createPatient(invalidPatient2);
        } catch (InvalidPatientDataException e) {
            System.out.println("❌ Validation Blocked Entry: " + e.getMessage());
        }
    }
}
