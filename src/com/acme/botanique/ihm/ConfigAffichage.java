package com.acme.botanique.ihm;

/**
 * Configuration d'affichage.
 */
public class ConfigAffichage implements Cloneable {

    /**
     * Affichage de la taille.
     */
    private boolean afficherTaille = false;

    /**
     * Constructeur.
     */
    public ConfigAffichage() {
    }

    /**
     * Si on affiche la taille d'une plante ou non.
     *
     * @return <code>true</code> si on doit afficher les tailles des plantes, <code>false</code> sinon
     */
    public boolean lireAfficherTaille() {
        return afficherTaille;
    }

    /**
     * Définir la valeur du paramètre d'affichage de taille.
     *
     * @param afficherTaille    paramètre d'affichage de taille
     */
    public void ecrireAfficherTaille(boolean afficherTaille) {
        this.afficherTaille = afficherTaille;
    }

    @Override
    protected ConfigAffichage clone() {
        ConfigAffichage clone = new ConfigAffichage();
        clone.afficherTaille = this.afficherTaille;
        return clone;
    }
}
