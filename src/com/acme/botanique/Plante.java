package com.acme.botanique;

/**
 * Une plante.
 *
 * Une plante est un organisme photosynthétique et autotrophe.
 *
 * @see "https://fr.wikipedia.org/wiki/Plante"
 */
public abstract class Plante {

    protected double taille;

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
        taille += n * lirePas();
    }

    @Override
    public String toString() {
        String rep = "";
        int nbFeuille = (int) taille / 10;
        for (int i = 0; i < nbFeuille; i++) {
            rep += "<-";
        }
        return rep;
    }

    public abstract String lireNom();

    protected abstract double lirePas();
}
