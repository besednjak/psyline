package com.uade.psyline.domain.therapist;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Entity;


public enum TherapyTreatment {
    ADICCIONES,
    ANALISIS_DE_SUEÑO,
    ANOREXIA,
    ANSIEDAD,
    ATAQUE_DE_PANICO,
    BULLYING,
    DEPENDENCIA_EMOCIONAL,
    DEPRESION,
    DUELO,
    ESTRES,
    TRASTORNO_POR_ESTRES_POSTRAUMATICO,
    INSOMNIO,
    LUDOPATIA,
    PSICOANALISIS,
    SEXOLOGIA,
    SUICIDIO,
    TDAH,
    COGNITIVO_CONDUCTUAL,
    TERAPIA_FAMILIAR,
    TERAPIA_GRUPAL;
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



