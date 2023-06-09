package com.uade.psyline.domain.address;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CABANeighborhood {
    AGRONOMIA,
    ALMAGRO,
    BALVANERA,
    BARRACAS,
    BELGRANO,
    BOCA,
    BOEDO,
    CABALLITO,
    CHACARITA,
    COGHLAN,
    COLEGIALES,
    CONSTITUCION,
    FLORES,
    FLORESTA,
    LINIERS,
    MATADEROS,
    MONSERRAT,
    MONTECASTRO,
    NUEVA_POMPEYA,
    NUNEZ,
    PALERMO,
    PARQUE_AVELLANEDA,
    PARQUE_CHACABUCO,
    PARQUE_CHAS,
    PARQUE_PATRICIOS,
    PATERNAL,
    PUERTO_MADERO,
    RECOLETA,
    RETIRO,
    SAAVEDRA,
    SAN_CRISTOBAL,
    SAN_NICOLAS,
    SAN_TELMO,
    VERSALLES,
    VILLA_CRESPO,
    VILLA_DEL_PARQUE,
    VILLA_DEVOTO,
    VILLA_GRAL_MITRE,
    VILLA_LUGANO,
    VILLA_LURO,
    VILLA_ORTUZAR,
    VILLA_PUEYRREDON,
    VILLA_REAL,
    VILLA_RIACHUELO,
    VILLA_SANTA_RITA,
    VILLA_SOLDATI,
    VILLA_URQUIZA;

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