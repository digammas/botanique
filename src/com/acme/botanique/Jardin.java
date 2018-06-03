package com.acme.botanique;

import java.util.Scanner;

/**
 * Classe principale.
 */
public class Jardin {

    private static Plante[] plantes = new Plante[] {new Plante(), new Plante(20), new Plante(45)};

    /**
     * Le rapport CM/pouce.
     */
    private static final double CM_A_POUCE = 0.393701;

    public static void main(String[] args) {
        System.out.println("Bonjour Jardin!");

        Scanner scanner = new Scanner(System.in);

        // Arroser la plante
        System.out.println("Combien de fois voulez-vous arroser la plante?");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Désolé, je n'ai pas compris. Veuillez renseigner à un chiffre entier.");
        }
        int n = scanner.nextInt();

        arroser(n);

        System.out.println("Quelle unité voulez-vous utiliser pour l'affichage?");
        String unite = scanner.next();

        afficher(unite);
        System.out.println("Vos plantes vous remercient de les avoir arrosé.");

        scanner.close();
    }

    private static void arroser(int n) {
        for (Plante plante : plantes) {
            plante.arroser(n);
        }
    }

    private static void afficher(String unite) {
        for (Plante plante : plantes) {
            afficher(plante.lireTaille(), unite);
        }
    }

    private static void afficher(double taille, String unite) {
        switch (unite.toLowerCase()) {
        case "cm":
            System.out.println("Taille après l'arrosage: " + taille + " cm.");
            break;
        case "pouce":
            System.out.println("Taille après l'arrosage: " + convertirEnPouce(taille) + " pouce.");
            break;
        default:
            System.out.println("Désolé, je ne connais pas " + unite + " comme unité!");
        }
    }

    private static double convertirEnPouce(double taille) {
        return taille * CM_A_POUCE;
    }
}
