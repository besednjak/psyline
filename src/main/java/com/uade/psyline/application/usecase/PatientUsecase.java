package com.uade.psyline.application.usecase;

import com.uade.psyline.application.exception.PatientNotFoundException;
import com.uade.psyline.application.service.PatientService;
import com.uade.psyline.infra.repository.mysql.dao.PatientDAO;
import com.uade.psyline.presentation.dto.PatientDTO;
import com.uade.psyline.infra.repository.mysql.jpa.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class PatientUsecase implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional
    public PatientDTO postPatient(PatientDTO newPatientDTO) {
        PatientDAO newPatientDAO = mapper.map(newPatientDTO, PatientDAO.class);
        patientRepository.save(newPatientDAO);
        return mapper.map(newPatientDAO, PatientDTO.class);
    }

    @Override
    public PatientDTO getPatient(String userName) {
        PatientDAO patientFoundDAO = this.findPatientByUserName(userName);
        return mapper.map(patientFoundDAO, PatientDTO.class);
    }

    @Override
    @Transactional
    public PatientDTO updatePatient(PatientDTO updatedPatientDTO) {
        this.findPatientByUserName(updatedPatientDTO.getUserName());
        PatientDAO updatedPatientDAO = mapper.map(updatedPatientDTO, PatientDAO.class);
        patientRepository.save(updatedPatientDAO);
        return mapper.map(updatedPatientDAO, PatientDTO.class);
    }

    @Override
    public PatientDTO deletePatient(String userName) {
        PatientDAO patientFoundDAO = this.findPatientByUserName(userName);
        patientRepository.delete(patientFoundDAO);
        return mapper.map(patientFoundDAO, PatientDTO.class);
    }

    private PatientDAO findPatientByUserName(String userName) {
        PatientDAO patientFoundDAO = patientRepository.findPatientByUserName(userName);
        if(patientFoundDAO == null) {
            throw new PatientNotFoundException();
        }
        return patientFoundDAO;
    }
}
