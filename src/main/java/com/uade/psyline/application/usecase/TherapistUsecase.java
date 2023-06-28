package com.uade.psyline.application.usecase;

import com.uade.psyline.application.exception.TherapistNotFoundException;
import com.uade.psyline.application.service.TherapistService;
import com.uade.psyline.domain.address.CABANeighborhood;
import com.uade.psyline.domain.therapist.AppointmentModality;
import com.uade.psyline.domain.therapist.Specialty;
import com.uade.psyline.domain.therapist.TherapyTreatment;
import com.uade.psyline.infra.repository.mysql.dao.TherapistDAO;
import com.uade.psyline.infra.repository.mysql.dao.TherapyTreatmentDAO;
import com.uade.psyline.infra.repository.mysql.dao.WorkingTimeDAO;
import com.uade.psyline.infra.repository.mysql.jpa.TherapistRepository;
import com.uade.psyline.infra.repository.mysql.jpa.WorkingTimeRepository;
import com.uade.psyline.presentation.dto.TherapistDTO;
import com.uade.psyline.presentation.dto.WorkingTimeDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TherapistUsecase implements TherapistService {

    @Autowired
    private TherapistRepository therapistRepository;
    @Autowired
    private WorkingTimeRepository workingTimeRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional
    public TherapistDTO postTherapist(TherapistDTO newTherapistDTO) {
        TherapistDAO newTherapistDAO = mapper.map(newTherapistDTO, TherapistDAO.class);
        therapistRepository.save(newTherapistDAO);
        return mapper.map(newTherapistDAO, TherapistDTO.class);
    }

    @Override
    @Transactional
    public TherapistDTO getTherapist(String userName) {
        TherapistDAO therapistFoundDAO = this.findTherapistByUserName(userName);
        return mapper.map(therapistFoundDAO, TherapistDTO.class);
    }

    @Override
    @Transactional
    public TherapistDTO updateTherapist(TherapistDTO updatedTherapistDTO) {
        TherapistDAO existingTherapistDAO = this.findTherapistByUserName(updatedTherapistDTO.getUserName());
        TherapistDAO updatedTherapistDAO = mapper.map(updatedTherapistDTO, TherapistDAO.class);
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.map(updatedTherapistDAO, existingTherapistDAO);
        therapistRepository.save(existingTherapistDAO);

        return mapper.map(existingTherapistDAO, TherapistDTO.class);
    }

    @Override
    @Transactional
    public TherapistDTO updateTherapistSchedule(String userName, Set<WorkingTimeDTO> newScheduleDTO) {
        TherapistDAO existingTherapistDAO = this.findTherapistByUserName(userName);
        workingTimeRepository.deleteAll(existingTherapistDAO.getWorkingSchedule());

        Set<WorkingTimeDAO> newScheduleDAO = new HashSet<>();
        newScheduleDTO.forEach(newWorkingTimeDTO -> {
            WorkingTimeDAO newWorkingTimeDAO = mapper.map(newWorkingTimeDTO, WorkingTimeDAO.class);
            newWorkingTimeDAO.setTherapist(existingTherapistDAO);
            workingTimeRepository.save(newWorkingTimeDAO);
            newScheduleDAO.add(newWorkingTimeDAO);
        });

        existingTherapistDAO.setWorkingSchedule(newScheduleDAO);
        return mapper.map(existingTherapistDAO, TherapistDTO.class);
    }

    @Override
    public TherapistDTO deleteTherapist(String userName) {
        TherapistDAO therapistFoundDAO = this.findTherapistByUserName(userName);
        therapistRepository.delete(therapistFoundDAO);
        return mapper.map(therapistFoundDAO, TherapistDTO.class);
    }

    @Override
    @Transactional
    public List<TherapistDTO> getTherapists(AppointmentModality modality, Specialty specialty, CABANeighborhood practiceArea, Double minPrice, Double maxPrice, Set<TherapyTreatment> therapyTreatments) {
        List<TherapistDAO> therapistDAOS = therapistRepository.findAllByFilters(specialty, practiceArea, minPrice, maxPrice);
        List<TherapistDAO> filteredTherapists = new ArrayList<>();
        for(TherapistDAO therapist : therapistDAOS){
            if(isFilteredByModality(therapist, modality)){
                if(isFilteredByTherapyTreatments(therapist, therapyTreatments)){
                    filteredTherapists.add(therapist);
                }
            }
        }
        return filteredTherapists.stream().map(therapistDAO -> mapper.map(therapistDAO, TherapistDTO.class)).toList();
    }

    private boolean isFilteredByTherapyTreatments(TherapistDAO therapist, Set<TherapyTreatment> therapyTreatments){
        if(therapyTreatments == null || therapyTreatments.isEmpty()){
            return true;
        }
        else {
            Set<TherapyTreatment> therapistTherapyTreatments = new HashSet<>(
                    therapist.getTherapyTreatments().stream().map(TherapyTreatmentDAO::getTherapyTreatment).toList()
            );
            return therapistTherapyTreatments.containsAll(therapyTreatments);
        }
    }

    private boolean isFilteredByModality(TherapistDAO therapist, AppointmentModality modality){
        if(modality == null){
            return true;
        }
        if(modality == AppointmentModality.IN_PERSON || modality == AppointmentModality.VIRTUAL){
            return therapist.getAppointmentModality().equals(AppointmentModality.HYBRID) ||
                    therapist.getAppointmentModality().equals(modality);
        }
        else{
            return therapist.getAppointmentModality().equals(modality);
        }
    }

    private TherapistDAO findTherapistByUserName(String userName) {
        TherapistDAO therapistFoundDAO = therapistRepository.findTherapistByUserName(userName);
        if(therapistFoundDAO == null) {
            throw new TherapistNotFoundException();
        }
        return therapistFoundDAO;
    }
}
