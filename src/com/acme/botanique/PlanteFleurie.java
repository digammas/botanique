package com.acme.botanique;

/**
 * Une plante à fleur.
 */
public abstract class PlanteFleurie extends Plante {

    /**
     * Constructeur sans argument.
     */
    public PlanteFleurie() {
        this(25);
    }

    /**
     * Constructeur avec un paramètre.
     *
     * @param taille    la taille initiale de la plante
     */
    public PlanteFleurie(double taille) {
        super(taille);
    }

}
