package com.acme.botanique;

import com.acme.culinaire.Comestible;

import java.util.Formatter;

/**
 * Classe principale.
 */
public class Jardin {

    /**
     * Toutes les plantes dans le jardin.
     */
    private Plante[] plantes = new Plante[] { new Basilic(30), new Geranium(), new Basilic() };

    /**
     * L'enseble des plantes du jardin.
     * 
     * @return  les plante en tant que tableau
     */
    public Plante[] lirePlantes() {
        return plantes;
    }

    /**
     * Arroser toutes les plantes, n fois.
     *
     * @param n     nombre de fois d'arrosage
     * @throws ArrosageException    lors que une erreur d'arrosage s'est produite
     */
    public void arroser(int n) throws ArrosageException {
        for (Plante plante : plantes) {
            plante.arroser(n);
        }
    }

    public double calculerValeurNutritionnelle() {
        double valeur = 0.0;
        for (Plante plante : plantes) {
            if (plante instanceof Comestible) {
                Comestible comestible = (Comestible) plante;
                valeur += comestible.lireValeurNutritionnelle();
            }
        }
        return valeur;
    }

    @Override
    public String toString() {
        Formatter rep = new Formatter();
        for (Plante plante : plantes) {
            rep.format("%s:\t%s\n", plante.lireNom(), plante.toString());
        }
        return rep.toString();
    }
}
