package com.Patient.APIPatient.service;

import com.Patient.APIPatient.Exception.PatientNotFoundException;
import com.Patient.APIPatient.models.Patient;
import com.Patient.APIPatient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Eine Service Bauen
public class PatientService {
    public PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient){
        return this.patientRepository.save(patient);
    }
    public List<Patient> getAllsPatient(){
        return this.patientRepository.findAll();
    }

    public Optional<Patient> getOnePatient(Long id){
        Optional<Patient> patient = this.patientRepository.findById(id);
        if(!patient.isPresent()){
            throw  new PatientNotFoundException("Patient with %s not found"+id);
        }
        return patient;
    }

    public Patient upDatePatient(Patient patient, Long id){
        Optional<Patient> patientExit = this.patientRepository.findById(id);
        if(!patientExit.isPresent()){
            throw  new PatientNotFoundException("Patient with %s not found"+id);
        }
        return this.patientRepository.save(patient);
    }

    public void removePatient(Long id){
        Optional<Patient> patient = this.patientRepository.findById(id);
        if(!patient.isPresent()){
            throw  new PatientNotFoundException("Patient with %s not found"+id);
        }
        this.patientRepository.delete(patient.get());
    }
}
