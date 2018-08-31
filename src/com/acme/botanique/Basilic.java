package com.acme.botanique;

import com.acme.culinaire.Comestible;

/**
 * Une plante de basilic.
 */
public class Basilic extends Plante implements Comestible {

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

    @Override
    protected double lirePas() {
        return 0.2;
    }

    @Override
    public double lireValeurNutritionnelle() {
        return taille * 1.5;
    }

    @Override
    public FormePlante lireForme() {
        return FormePlante.HERBE;
    }
}
