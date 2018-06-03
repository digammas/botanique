package com.acme.botanique;

/**
 * Une fleur d'une plante.
 */
public class Fleur {

    /**
     * Nombre des pétales. Initialement zéro.
     */
    private int nombrePetales = 0;

    public int lireNombrePetales() {
        return nombrePetales;
    }

    public void arroser(int n) {
        if (n > 2) {
            nombrePetales += 2;
        } else {
            nombrePetales++;
        }
    }
}
