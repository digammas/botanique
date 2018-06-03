package com.acme.botanique;

/**
 * Une plante de Géranium.
 */
public class Geranium extends Plante {

    /**
     * Constructeur sans argument.
     */
    public Geranium() {
        super(20);
    }

    @Override
    public void arroser(int n) {
        taille += n * 0.1;
    }

    @Override
    public String lireNom() {
        return "Géranium";
    }
}
