package com.uade.psyline.application.exception;

import lombok.Getter;

@Getter
public class WorkingTimeNotFoundException extends RuntimeException{
    private final String message = "working time not found";
}
