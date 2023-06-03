package com.uade.psyline.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PatientDTO {

    private String userName;
    private String name;
    private String lastName;
    private LocalDate birthDate;
}
