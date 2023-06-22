package com.uade.psyline.application.usecase;

import com.uade.psyline.application.exception.TherapistNotFoundException;
import com.uade.psyline.application.service.TherapistService;
import com.uade.psyline.domain.address.CABANeighborhood;
import com.uade.psyline.domain.therapist.AppointmentModality;
import com.uade.psyline.domain.therapist.Specialty;
import com.uade.psyline.domain.therapist.TherapyTreatment;
import com.uade.psyline.infra.repository.mysql.dao.TherapistDAO;
import com.uade.psyline.infra.repository.mysql.jpa.TherapistRepository;
import com.uade.psyline.presentation.dto.TherapistDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TherapistUsecase implements TherapistService {

    @Autowired
    private TherapistRepository therapistRepository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional
    public TherapistDTO postTherapist(TherapistDTO newTherapistDTO) {
        TherapistDAO newTherapistDAO = mapper.map(newTherapistDTO, TherapistDAO.class);
        therapistRepository.save(newTherapistDAO);
        return mapper.map(newTherapistDAO, TherapistDTO.class);
    }

    @Override
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
    public TherapistDTO deleteTherapist(String userName) {
        TherapistDAO therapistFoundDAO = this.findTherapistByUserName(userName);
        therapistRepository.delete(therapistFoundDAO);
        return mapper.map(therapistFoundDAO, TherapistDTO.class);
    }

    @Override
    public List<TherapistDTO> getTherapists(AppointmentModality modality, Specialty specialty, CABANeighborhood practiceArea, Double minPrice, Double maxPrice, Set<TherapyTreatment> therapyTreatments) {
        List<TherapistDAO> therapistDAOS = therapistRepository.findAllByFilters(modality, specialty, practiceArea, minPrice, maxPrice, therapyTreatments);
        return therapistDAOS.stream().map(therapistDAO -> mapper.map(therapistDAO, TherapistDTO.class)).toList();
    }

    private TherapistDAO findTherapistByUserName(String userName) {
        TherapistDAO therapistFoundDAO = therapistRepository.findTherapistByUserName(userName);
        if(therapistFoundDAO == null) {
            throw new TherapistNotFoundException();
        }
        return therapistFoundDAO;
    }
}
