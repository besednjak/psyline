package com.uade.psyline.application.exception;

import lombok.Getter;

@Getter
public class PatientNotFoundException extends RuntimeException {

    private final String message = "patient not found";
}
