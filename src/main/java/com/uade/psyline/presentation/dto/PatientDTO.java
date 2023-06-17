package com.uade.psyline.presentation.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class PatientDTO {

    private String userName;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private Set<JournalEntryDTO> journal;
}
