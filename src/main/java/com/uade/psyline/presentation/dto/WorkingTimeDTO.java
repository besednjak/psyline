package com.uade.psyline.presentation.dto;

import com.uade.psyline.infra.repository.mysql.dao.TherapistDAO;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WorkingTimeDTO {

    private Integer id;
    private TherapistDAO therapist;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private String therapistUserName;

}
