package org.mutua.teammorale.data;

public enum Emotion {
    ACTIVADO(EmotionLevel.ALTA_ACTIVACION), ASOMBRADO(EmotionLevel.ALTA_ACTIVACION),
    PASMADO(EmotionLevel.ALTA_ACTIVACION),ESTIMULADO(EmotionLevel.ALTA_ACTIVACION),
    SORPRENDIO(EmotionLevel.ALTA_ACTIVACION),

    ENTUSIASMADO(EmotionLevel.AFECTO_AGRADABLE_ACTIVADO),INTERESADO(EmotionLevel.AFECTO_AGRADABLE_ACTIVADO),
    EUFORICO(EmotionLevel.AFECTO_AGRADABLE_ACTIVADO), EXITADO(EmotionLevel.AFECTO_AGRADABLE_ACTIVADO),
    CON_ENERGIA(EmotionLevel.AFECTO_AGRADABLE_ACTIVADO), LLENO_DE_VIDA(EmotionLevel.AFECTO_AGRADABLE_ACTIVADO),

    FELIZ(EmotionLevel.AGRADABLE), ALEGRE(EmotionLevel.AGRADABLE), COMPLACIDO(EmotionLevel.AGRADABLE),
    CONTENTO(EmotionLevel.AGRADABLE), AFECTUOSO(EmotionLevel.AGRADABLE), SATISFFECHO(EmotionLevel.AGRADABLE),

    RELAJADO(EmotionLevel.AFECTO_AGRADABLE_NO_ACTIVADO), DESCANSADO(EmotionLevel.AFECTO_AGRADABLE_NO_ACTIVADO),
    CALMADO(EmotionLevel.AFECTO_AGRADABLE_NO_ACTIVADO), SERENO(EmotionLevel.AFECTO_AGRADABLE_NO_ACTIVADO),
    TRANQUILO(EmotionLevel.AFECTO_AGRADABLE_NO_ACTIVADO),

    CALLADO(EmotionLevel.BAJA_ACTIVACION), INACTIVO(EmotionLevel.BAJA_ACTIVACION),OCIOSO(EmotionLevel.BAJA_ACTIVACION),
    PASIVO(EmotionLevel.BAJA_ACTIVACION),

    CANSADO(EmotionLevel.AFECTO_DESAGRADABLE_NO_ACTIVADO), ABURRIDO(EmotionLevel.AFECTO_DESAGRADABLE_NO_ACTIVADO),
    SOMNOLIENTO(EmotionLevel.AFECTO_DESAGRADABLE_NO_ACTIVADO), PESADO(EmotionLevel.AFECTO_DESAGRADABLE_NO_ACTIVADO),
    DESGANADO(EmotionLevel.AFECTO_DESAGRADABLE_NO_ACTIVADO),

    DESAGRACIADO(EmotionLevel.DESAGRADABLE), TRISTE(EmotionLevel.DESAGRADABLE), DEPRIMIDO(EmotionLevel.DESAGRADABLE),
    AFLIGIDO(EmotionLevel.DESAGRADABLE), DESOLADO(EmotionLevel.DESAGRADABLE), DESANIMADO(EmotionLevel.DESAGRADABLE),

    ANSIOSO(EmotionLevel.AFECTO_DESAGRADABLE_ACTIVADO), ANGUSTIADO(EmotionLevel.AFECTO_DESAGRADABLE_ACTIVADO),
    IRRITADDO(EmotionLevel.AFECTO_DESAGRADABLE_ACTIVADO), TEMEROSO(EmotionLevel.AFECTO_DESAGRADABLE_ACTIVADO),
    NERVIOSO(EmotionLevel.AFECTO_DESAGRADABLE_ACTIVADO)


    ;


    public final EmotionLevel level;

    Emotion(EmotionLevel level){
        this.level = level;
    }


}