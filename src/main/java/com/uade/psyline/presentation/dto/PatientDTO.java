package com.uade.psyline.presentation.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PatientDTO {

    private String userName;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
}
