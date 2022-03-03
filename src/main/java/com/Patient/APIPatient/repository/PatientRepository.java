package com.Patient.APIPatient.repository;

import com.Patient.APIPatient.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
