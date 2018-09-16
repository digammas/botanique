package com.acme.botanique;

/**
 * Une plante.
 *
 * Une plante est un organisme photosynthétique et autotrophe.
 *
 * @see "https://fr.wikipedia.org/wiki/Plante"
 */
public class Plante {

    double taille;

    Plante() {
        this(30);
    }

    Plante(double taille) {
        this.taille = taille;
    }
}
