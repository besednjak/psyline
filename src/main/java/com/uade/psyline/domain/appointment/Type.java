package com.uade.psyline.domain.appointment;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {
    PRESENCIAL,
    VIRTUAL;
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
