package com.acme.botanique;

import com.acme.outils.Mesure;

import java.util.Scanner;

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

    /**
     * Afficher toutes les plantes.
     *
     * @param unite     unité utilisée pour l'affichage de taille
     */
    public void afficher(String unite) {
        for (Plante plante : plantes) {
            System.out.println(plante.lireNom());
            afficher(plante.lireTaille(), unite);
        }
    }

    /**
     * Point d'entrée de l'application.
     *
     * @param args  liste d'arguments
     */
    public static void main(String[] args) {
        System.out.println("Bonjour Jardin!");

        Scanner scanner = new Scanner(System.in);

        Jardin monJardin = new Jardin();
        // Arroser la plante
        System.out.println("Combien de fois voulez-vous arroser la plante?");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Désolé, je n'ai pas compris. Veuillez renseigner à un chiffre entier.");
        }
        int n = scanner.nextInt();

        monJardin.arroser(n);

        System.out.println("Quelle unité voulez-vous utiliser pour l'affichage?");
        String unite = scanner.next();

        monJardin.afficher(unite);
        System.out.println("Vos plantes vous remercient de les avoir arrosé.");

        scanner.close();
    }

    /**
     * Méthode utilitaire pour afficher la taille après l'arrosage dans une unité donnée.
     *
     * @param taille        la taille
     * @param unite         l'unité
     */
    private static void afficher(double taille, String unite) {
        switch (unite.toLowerCase()) {
        case "cm":
            System.out.println("Taille après l'arrosage: " + taille + " cm.");
            break;
        case "pouce":
            System.out.println("Taille après l'arrosage: " + Mesure.convertir(taille, Mesure.CM_A_POUCE) + " pouce.");
            break;
        default:
            System.out.println("Désolé, je ne connais pas " + unite + " comme unité!");
        }
    }
}
