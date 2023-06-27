package com.uade.psyline.presentation.dto;

import com.uade.psyline.domain.appointment.Status;
import com.uade.psyline.domain.appointment.Type;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AppointmentDTO {

    private Integer id;
    private LocalDateTime dateTime;
    private Double price;
    private boolean paid;
    private Status status;
    private Type type;
    private String therapistUserName;
    private String patientUserName;
    private String invoice;
}
