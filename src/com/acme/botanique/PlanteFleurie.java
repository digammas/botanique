package com.acme.botanique;

import java.util.ArrayList;
import java.util.List;

/**
 * Une plante à fleur.
 */
public abstract class PlanteFleurie extends Plante {

    private List<Fleur> fleurs = new ArrayList<>();
    private Fleur bouton = new Fleur();

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
        fleurs.add(bouton);
    }

    public List<Fleur> lireFleurs() {
        return fleurs;
    }

    @Override
    public void arroser(int n) throws ArrosageException {
        super.arroser(n);
        bouton.arroser(n);
        if (bouton.estOuverte()) {
            bouton = new Fleur();
            fleurs.add(bouton);
        }
    }

    @Override
    public String toString() {
        StringBuilder rep = new StringBuilder(super.toString());
        for (Fleur fleur : fleurs) {
            rep.append(fleur.toString());
        }
        return rep.toString();
    }
}
