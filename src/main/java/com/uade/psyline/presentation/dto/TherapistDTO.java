package com.uade.psyline.presentation.dto;

import com.uade.psyline.domain.therapist.AppointmentModality;
import com.uade.psyline.domain.therapist.Specialty;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TherapistDTO {

    private String userName;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String licence;
    private Specialty specialty;
    private AppointmentModality appointmentModality;
    private String practiceArea;
    private String phoneNumber;
    private String email;
    private String bio;
    private Double appointmentPrice;
    private Set<AppointmentDTO> appointments;
    private Set<WorkingTimeDTO> workingSchedule;

}
