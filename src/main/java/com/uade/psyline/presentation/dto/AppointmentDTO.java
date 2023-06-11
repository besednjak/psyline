package com.uade.psyline.presentation.dto;

import com.uade.psyline.domain.appointment.Status;
import com.uade.psyline.domain.appointment.Type;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AppointmentDTO {

    private Integer id;
    private LocalDate date;
    private Double price;
    private boolean paid;
    private Status status;
    private Type type;
    private TherapistDTO therapist;
    private PatientDTO patient;
}
