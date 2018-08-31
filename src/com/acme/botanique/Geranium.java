package com.acme.botanique;

/**
 * Une plante de Géranium.
 */
public class Geranium extends PlanteFleurie {

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

    @Override
    public FormePlante lireForme() {
        return taille > 100 ? FormePlante.ARBRISSEAU : FormePlante.HERBE;
    }
}
