package com.uade.psyline.application.exception;

import lombok.Getter;

@Getter
public class TherapistNotFoundException extends RuntimeException {
    private final String message = "Therapist not found";
}
