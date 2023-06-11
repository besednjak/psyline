package com.uade.psyline.presentation.dto;

import com.uade.psyline.domain.patient.Emotion;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JournalEntryDTO {

    private Integer id;
    private LocalDate date;
    private Emotion emotion;
    private String description;

}
