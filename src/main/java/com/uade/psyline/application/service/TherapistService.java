package com.uade.psyline.application.service;

import com.uade.psyline.domain.address.CABANeighborhood;
import com.uade.psyline.domain.therapist.AppointmentModality;
import com.uade.psyline.domain.therapist.Specialty;
import com.uade.psyline.domain.therapist.TherapyTreatment;
import com.uade.psyline.presentation.dto.TherapistDTO;
import com.uade.psyline.presentation.dto.WorkingTimeDTO;

import java.util.List;
import java.util.Set;

public interface TherapistService {
    TherapistDTO postTherapist(TherapistDTO newPatient);

    TherapistDTO getTherapist(String userName);

    TherapistDTO updateTherapist(TherapistDTO updatedPatientDTO);

    TherapistDTO deleteTherapist(String userName);

    List<TherapistDTO> getTherapists(AppointmentModality modality, Specialty specialty, CABANeighborhood neighborhood, Double minPrice, Double maxPrice, Set<TherapyTreatment> therapyTreatments);

    TherapistDTO updateTherapistSchedule(String userName, Set<WorkingTimeDTO> newSchedule);

    TherapistDTO deleteTherapistWorkingTime(String userName, Integer workingTimeId);
}
