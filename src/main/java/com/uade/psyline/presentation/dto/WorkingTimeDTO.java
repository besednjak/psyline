package com.uade.psyline.presentation.dto;

import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WorkingTimeDTO {

    private Integer id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

}
