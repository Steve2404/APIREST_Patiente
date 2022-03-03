package com.Patient.APIPatient.controller;

import com.Patient.APIPatient.models.Patient;
import com.Patient.APIPatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.form.OptionsTag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/rest", name = "api_patient_")
public class PatientController {
    public PatientService patientService;

    @Autowired // injizierbarer Constructor
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    //Post
    @PostMapping(path = "/patient", name = "create") // mapping oder uri
    @ResponseStatus(HttpStatus.CREATED) // code response
    public Patient add(@RequestBody Patient patient){
        return this.patientService.savePatient(patient);
    }

    // Get uber auf alle Datensätze in der Tabelle
    @GetMapping(path = "/patient", name = "list")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> list(){
        return this.patientService.getAllsPatient();
    }

    // Get uber auf einen Datensatz in der Tabelle
    @GetMapping(path = "/patient/{id}", name = "read")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Patient> read(@PathVariable Long id){
        return this.patientService.getOnePatient(id);
    }

    //UpDate
    @PutMapping(path = "/patient/{id}", name = "update")
    @ResponseStatus(HttpStatus.OK)
    public Patient upDate(@RequestBody Patient patient, @PathVariable Long id){
        return this.patientService.upDatePatient(patient, id);
    }

    //Delete
    @DeleteMapping(path = "/patient/{id}", name = "remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id){
        this.patientService.removePatient(id);
    }
}
