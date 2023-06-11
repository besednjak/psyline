package com.uade.psyline.application.usecase;

import com.uade.psyline.application.exception.AppointmentNotFoundException;
import com.uade.psyline.application.service.AppointmentService;
import com.uade.psyline.infra.repository.mysql.dao.AppointmentDAO;
import com.uade.psyline.infra.repository.mysql.jpa.AppointmentRepository;
import com.uade.psyline.presentation.dto.AppointmentDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentUsecase implements AppointmentService {
    private final ModelMapper mapper = new ModelMapper();
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    @Transactional
    public AppointmentDTO postAppointment(AppointmentDTO newAppointmentDTO){
        AppointmentDAO newAppointmentDAO = mapper.map(newAppointmentDTO, AppointmentDAO.class);
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

    private AppointmentDAO findAppointmentById(Integer id) {
        AppointmentDAO appointmentFoundDAO = appointmentRepository.findAppointmentById(id);
        if(appointmentFoundDAO == null) {
            throw new AppointmentNotFoundException();
        }
        return appointmentFoundDAO;
    }
}
