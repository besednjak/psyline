package com.uade.psyline.application.service;

import com.uade.psyline.presentation.dto.TherapistDTO;

public interface TherapistService {
    TherapistDTO postTherapist(TherapistDTO newPatient);

    TherapistDTO getTherapist(String userName);

    TherapistDTO updateTherapist(TherapistDTO updatedPatientDTO);

    TherapistDTO deleteTherapist(String userName);
}
