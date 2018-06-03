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
    public String lireNom() {
        return "Géranium";
    }

    @Override
    protected double lirePas() {
        return 0.1;
    }
}
