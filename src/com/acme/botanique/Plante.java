package com.acme.botanique;

/**
 * Une plante.
 *
 * Une plante est un organisme photosynthétique et autotrophe.
 *
 * @see "https://fr.wikipedia.org/wiki/Plante"
 */
public class Plante {

    private double taille;

    public Plante() {
        this(30);
    }

    public Plante(double taille) {
        this.taille = taille;
    }

    public double lireTaille() {
        return taille;
    }

    public void arroser(int n) {
        taille += n * 0.25;
    }

    public String lireNom() {
        return "Plante inconnue";
    }
}
