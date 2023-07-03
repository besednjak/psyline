package com.uade.psyline.application.exception;

import lombok.Getter;

@Getter
public class JournalEntryNotFoundException extends RuntimeException {

    private final String message = "journal entry not found";
}
