package com.acme.outils;

/**
 * Classe utilitaire pour convertir les différents mésures.
 */
public class Mesure {

    /**
     * Le rapport CM/pouce.
     */
    public static final double CM_A_POUCE = 0.393701;

    /**
     * Le rapport pouce/CM.
     */
    public static final double POUCE_A_CM = 1.0 / CM_A_POUCE;

    /**
     * Convertir une mesure à une nouvelle unité.
     *
     * @param mesure    la mesure en unité source
     * @param ratio     le rapport entre les deux unités
     * @return          la mesure en unité destination
     */
    public static double convertir(double mesure, double ratio) {
        return mesure * ratio;
    }
}
