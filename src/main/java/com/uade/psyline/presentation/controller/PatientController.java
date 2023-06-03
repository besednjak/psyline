package com.uade.psyline.presentation.controller;

import com.uade.psyline.application.service.PatientService;
import com.uade.psyline.presentation.dto.PatientDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
@Validated
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> postPatient(@RequestBody @Valid PatientDTO newPatientDTO) {
        return new ResponseEntity<>(patientService.postPatient(newPatientDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable String userName) {
        return new ResponseEntity<>(patientService.getPatient(userName), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PatientDTO> updatePatient(@RequestBody @Valid PatientDTO updatedPatientDTO) {
        return new ResponseEntity<>(patientService.updatePatient(updatedPatientDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<PatientDTO> deletePatient(@PathVariable String userName) {
        return new ResponseEntity<>(patientService.deletePatient(userName), HttpStatus.OK);
    }
}
