package com.uade.psyline.application.usecase;

import com.uade.psyline.application.exception.AppointmentNotFoundException;
import com.uade.psyline.application.exception.PatientNotFoundException;
import com.uade.psyline.application.exception.TherapistNotFoundException;
import com.uade.psyline.application.service.AppointmentService;
import com.uade.psyline.infra.repository.mysql.dao.AppointmentDAO;
import com.uade.psyline.infra.repository.mysql.dao.PatientDAO;
import com.uade.psyline.infra.repository.mysql.dao.TherapistDAO;
import com.uade.psyline.infra.repository.mysql.jpa.AppointmentRepository;
import com.uade.psyline.infra.repository.mysql.jpa.PatientRepository;
import com.uade.psyline.infra.repository.mysql.jpa.TherapistRepository;
import com.uade.psyline.presentation.dto.AppointmentDTO;
import com.uade.psyline.presentation.dto.TherapistDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentUsecase implements AppointmentService {
    private final ModelMapper mapper = new ModelMapper();
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private TherapistRepository therapistRepository;

    @Override
    @Transactional
    public AppointmentDTO postAppointment(AppointmentDTO newAppointmentDTO){
        PatientDAO patientDAO = findPatientByUserName(newAppointmentDTO.getPatientUserName());
        TherapistDAO therapistDAO = findTherapistByUserName(newAppointmentDTO.getTherapistUserName());
        AppointmentDAO newAppointmentDAO = mapper.map(newAppointmentDTO, AppointmentDAO.class);
        newAppointmentDAO.setPatient(patientDAO);
        newAppointmentDAO.setTherapist(therapistDAO);
        appointmentRepository.save(newAppointmentDAO);

        return mapper.map(newAppointmentDAO, AppointmentDTO.class);
    }

    @Override
    public AppointmentDTO getAppointment(Integer appointmentId){
        AppointmentDAO appointmentFoundDAO = this.findAppointmentById(appointmentId);
        return mapper.map(appointmentFoundDAO, AppointmentDTO.class);
    }

    @Override
    @Transactional
    public AppointmentDTO updateAppointment(AppointmentDTO updatedAppointmentDTO) {
        AppointmentDAO existingAppointmentDAO = this.findAppointmentById(updatedAppointmentDTO.getId());
        AppointmentDAO updatedAppointmentDAO = mapper.map(updatedAppointmentDTO, AppointmentDAO.class);
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.map(updatedAppointmentDAO, existingAppointmentDAO);
        appointmentRepository.save(existingAppointmentDAO);

        return mapper.map(existingAppointmentDAO, AppointmentDTO.class);
    }

    @Override
    public AppointmentDTO deleteAppointment(Integer appointmentId){
        AppointmentDAO appointmentFoundDAO = this.findAppointmentById(appointmentId);
        appointmentRepository.delete(appointmentFoundDAO);
        return mapper.map(appointmentFoundDAO, AppointmentDTO.class);
    }

    @Override
    public List<AppointmentDTO> getTherapistAppointments(String therapistUserName) {
        TherapistDAO therapistDAO = findTherapistByUserName(therapistUserName);

        return therapistDAO.getAppointments().stream()
                .map(appointmentDAO -> mapper.map(appointmentDAO, AppointmentDTO.class)).toList();
    }

    private AppointmentDAO findAppointmentById(Integer id) {
        AppointmentDAO appointmentFoundDAO = appointmentRepository.findAppointmentById(id);
        if(appointmentFoundDAO == null) {
            throw new AppointmentNotFoundException();
        }
        return appointmentFoundDAO;
    }

    private PatientDAO findPatientByUserName(String userName) {
        PatientDAO patientFoundDAO = patientRepository.findPatientByUserName(userName);
        if(patientFoundDAO == null) {
            throw new PatientNotFoundException();
        }
        return patientFoundDAO;
    }

    private TherapistDAO findTherapistByUserName(String userName) {
        TherapistDAO therapistFoundDAO = therapistRepository.findTherapistByUserName(userName);
        if(therapistFoundDAO == null) {
            throw new TherapistNotFoundException();
        }
        return therapistFoundDAO;
    }
}
