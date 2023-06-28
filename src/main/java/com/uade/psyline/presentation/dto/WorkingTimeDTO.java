package com.uade.psyline.presentation.dto;

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
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

}
