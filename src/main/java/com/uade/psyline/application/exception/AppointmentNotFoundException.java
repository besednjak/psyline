package com.uade.psyline.application.exception;
import lombok.Getter;

@Getter
public class AppointmentNotFoundException extends RuntimeException{
    private final String message = "appointment not found";
}
