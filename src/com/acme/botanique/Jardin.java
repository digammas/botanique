package com.acme.botanique;

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
     */
    public void arroser(int n) {
        for (Plante plante : plantes) {
            plante.arroser(n);
        }
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
