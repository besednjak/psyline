package com.uade.psyline.presentation.controller;

import com.uade.psyline.application.service.PatientService;
import com.uade.psyline.presentation.dto.JournalEntryDTO;
import com.uade.psyline.presentation.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> postPatient(@RequestBody PatientDTO newPatientDTO) {
        return new ResponseEntity<>(patientService.postPatient(newPatientDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable String userName) {
        return new ResponseEntity<>(patientService.getPatient(userName), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO updatedPatientDTO) {
        return new ResponseEntity<>(patientService.updatePatient(updatedPatientDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<PatientDTO> deletePatient(@PathVariable String userName) {
        return new ResponseEntity<>(patientService.deletePatient(userName), HttpStatus.OK);
    }

    @PostMapping("/{userName}/journal")
    public ResponseEntity<PatientDTO> postJournalEntry(@PathVariable String userName, @RequestBody JournalEntryDTO newJournalEntryDTO) {
        return new ResponseEntity<>(patientService.postJournalEntry(userName, newJournalEntryDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{userName}/journal")
    public ResponseEntity<PatientDTO> updateJournalEntry(@PathVariable String userName, @RequestBody JournalEntryDTO updatedJournalEntryDTO) {
        return new ResponseEntity<>(patientService.updateJournalEntry(userName, updatedJournalEntryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{userName}/journal/{journalEntryId}")
    public ResponseEntity<PatientDTO> deleteJournalEntry(@PathVariable String userName, @PathVariable Integer journalEntryId) {
        return new ResponseEntity<>(patientService.deleteJournalEntry(userName, journalEntryId), HttpStatus.OK);
    }

}
