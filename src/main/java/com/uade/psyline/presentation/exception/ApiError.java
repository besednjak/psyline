package com.uade.psyline.presentation.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Class containing relevant information from an API call error.
 * */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ApiError {

    private String error;

    private String message;

    private Integer status;

}