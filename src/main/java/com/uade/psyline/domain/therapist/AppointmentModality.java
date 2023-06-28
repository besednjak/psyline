package com.uade.psyline.domain.therapist;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AppointmentModality {

    PRESENCIAL,
    VIRTUAL,
    HIBRIDO;

    @Override
    @JsonValue
    public String toString() {
        String[] words = name().split("_");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(word.charAt(0))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }

        return result.toString().trim();
    }
}
