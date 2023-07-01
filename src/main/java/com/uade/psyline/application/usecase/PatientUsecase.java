package com.uade.psyline.application.usecase;

import com.uade.psyline.application.exception.JournalEntryNotFoundException;
import com.uade.psyline.application.exception.PatientNotFoundException;
import com.uade.psyline.application.service.PatientService;
import com.uade.psyline.infra.repository.mysql.dao.JournalEntryDAO;
import com.uade.psyline.infra.repository.mysql.dao.PatientDAO;
import com.uade.psyline.infra.repository.mysql.jpa.JournalEntryRepository;
import com.uade.psyline.infra.repository.mysql.jpa.PatientRepository;
import com.uade.psyline.presentation.dto.JournalEntryDTO;
import com.uade.psyline.presentation.dto.PatientDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientUsecase implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional
    public PatientDTO postPatient(PatientDTO newPatientDTO) {
        PatientDAO newPatientDAO = mapper.map(newPatientDTO, PatientDAO.class);
        patientRepository.save(newPatientDAO);
        return mapper.map(newPatientDAO, PatientDTO.class);
    }

    @Override
    @Transactional
    public PatientDTO getPatient(String userName) {
        PatientDAO patientFoundDAO = this.findPatientByUserName(userName);
        return mapper.map(patientFoundDAO, PatientDTO.class);
    }

    @Override
    @Transactional
    public PatientDTO updatePatient(PatientDTO updatedPatientDTO) {
        PatientDAO existingPatientDAO = this.findPatientByUserName(updatedPatientDTO.getUserName());
        PatientDAO updatedPatientDAO = mapper.map(updatedPatientDTO, PatientDAO.class);
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.map(updatedPatientDAO, existingPatientDAO);
        patientRepository.save(existingPatientDAO);

        return mapper.map(existingPatientDAO, PatientDTO.class);
    }

    @Override
    public PatientDTO deletePatient(String userName) {
        PatientDAO patientFoundDAO = this.findPatientByUserName(userName);
        patientRepository.delete(patientFoundDAO);
        return mapper.map(patientFoundDAO, PatientDTO.class);
    }

    @Override
    @Transactional
    public PatientDTO postJournalEntry(String userName, JournalEntryDTO newJournalEntryDTO) {
        PatientDAO patientFoundDAO = this.findPatientByUserName(userName);
        JournalEntryDAO newJournalEntryDAO = mapper.map(newJournalEntryDTO, JournalEntryDAO.class);
        newJournalEntryDAO.setPatient(patientFoundDAO);
        journalEntryRepository.save(newJournalEntryDAO);
        PatientDTO patientDTO = mapper.map(patientFoundDAO, PatientDTO.class);

        return patientDTO;
    }

    @Override
    @Transactional
    public PatientDTO updateJournalEntry(String userName, JournalEntryDTO updatedJournalEntryDTO) {
        JournalEntryDAO existingJournalEntryDAO = this.findJournalEntryBy(updatedJournalEntryDTO.getId());
        JournalEntryDAO updatedJournalEntryDAo = mapper.map(updatedJournalEntryDTO, JournalEntryDAO.class);
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.map(updatedJournalEntryDAo, existingJournalEntryDAO);
        journalEntryRepository.save(existingJournalEntryDAO);

        PatientDAO patientFoundDAO = this.findPatientByUserName(userName);
        return mapper.map(patientFoundDAO, PatientDTO.class);
    }

    @Override
    @Transactional
    public PatientDTO deleteJournalEntry(String userName, Integer journalEntryId) {
        JournalEntryDAO existingJournalEntryDAO = this.findJournalEntryBy(journalEntryId);
        journalEntryRepository.delete(existingJournalEntryDAO);

        PatientDAO patientFoundDAO = this.findPatientByUserName(userName);
        return mapper.map(patientFoundDAO, PatientDTO.class);
    }

    private PatientDAO findPatientByUserName(String userName) {
        PatientDAO patientFoundDAO = patientRepository.findPatientByUserName(userName);
        if(patientFoundDAO == null) {
            throw new PatientNotFoundException();
        }
        return patientFoundDAO;
    }

    private JournalEntryDAO findJournalEntryBy(Integer journalEntryId) {
        Optional<JournalEntryDAO> journalEntryDAOFound = journalEntryRepository.findById(journalEntryId);
        if(journalEntryDAOFound.isEmpty()) {
            throw new JournalEntryNotFoundException();
        }
        return journalEntryDAOFound.get();
    }
}
