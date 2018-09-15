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
     * Afficher la taille en pouce.
     */
    private boolean afficherEnPouce = false;

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

    /**
     * Si la taille s'affiche en pouce.
     *
     * @return  <code>true</code> si la taille doit s'afficher en pouce, <code>false</code> sinon
     */
    public boolean lireAfficherEnPouce() {
        return afficherEnPouce;
    }

    /**
     * Définir la valeur du paramètre d'utité de taille.
     *
     * @param afficherEnPouce    <code>true</code> si la taille doit s'afficher en pouce, <code>false</code> sinon
     */
    public void ecrireAfficherEnPouce(boolean afficherEnPouce) {
        this.afficherEnPouce = afficherEnPouce;
    }

    @Override
    protected ConfigAffichage clone() {
        ConfigAffichage clone = new ConfigAffichage();
        clone.afficherTaille = this.afficherTaille;
        clone.afficherEnPouce = this.afficherEnPouce;
        return clone;
    }
}
