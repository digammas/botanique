package com.acme.botanique;

/**
 * Une plante de basilic.
 */
public class Basilic extends Plante {

    /**
     * Constructeur sans argument.
     */
    public Basilic() {
        super(45);
    }

    /**
     * Constructeur avec un paramètre.
     *
     * @param taille    la taille initiale de la plante
     */
    public Basilic(double taille) {
        super(taille);
    }

    @Override
    public String lireNom() {
        return "Basilic";
    }
}
