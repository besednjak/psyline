package com.uade.psyline.application.service;

import com.uade.psyline.domain.address.CABANeighborhood;
import com.uade.psyline.domain.therapist.AppointmentModality;
import com.uade.psyline.domain.therapist.Specialty;
import com.uade.psyline.presentation.dto.TherapistDTO;

import java.util.List;

public interface TherapistService {
    TherapistDTO postTherapist(TherapistDTO newPatient);

    TherapistDTO getTherapist(String userName);

    TherapistDTO updateTherapist(TherapistDTO updatedPatientDTO);

    TherapistDTO deleteTherapist(String userName);

    List<TherapistDTO> getTherapists(AppointmentModality modality, Specialty specialty, CABANeighborhood neighborhood, Double minPrice, Double maxPrice);
}
