package com.uade.psyline.application.service;

import com.uade.psyline.presentation.dto.JournalEntryDTO;
import com.uade.psyline.presentation.dto.PatientDTO;

public interface PatientService {

    PatientDTO postPatient(PatientDTO newPatient);

    PatientDTO getPatient(String userName);

    PatientDTO updatePatient(PatientDTO updatedPatientDTO);

    PatientDTO deletePatient(String userName);

    PatientDTO postJournalEntry(String userName, JournalEntryDTO newJournalEntryDTO);

    PatientDTO updateJournalEntry(String userName, JournalEntryDTO updatedJournalEntryDTO);

    PatientDTO deleteJournalEntry(String userName, Integer journalEntryId);
}
