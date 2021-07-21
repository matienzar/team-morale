package org.focus.teammorale.data;

public enum EmotionLevel {

    // Modelo bifactorial circumplejo de la emoción
    ALTA_ACTIVACION("Alta activación",1),
    AFECTO_POSITIVO_ALTO("Afecto Positivo Alto",2),
    PLACER("Placer",3),
    AFECTO_NEGATIVO_BAJO("Afecto Negativo Bajo",4),
    BAJA_ACTIVACION("Baja activación",5),
    AFECTO_POSITIVO_BAJO("Afecto Positivo Bajo",6),
    DISPLACER("Displacer",7),
    AFECTO_NEGATIVO_ALTO("Afecto Negativo Alto",8);

    public final String traduccion;
    public final int orden;

    EmotionLevel(String traduccion, int orden){
        this.traduccion = traduccion;
        this.orden = orden;
    }

    @Override
    public String toString() {
        return traduccion;
    }
}
