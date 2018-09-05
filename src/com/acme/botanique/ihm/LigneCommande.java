package com.acme.botanique.ihm;

import com.acme.botanique.Jardin;

import java.util.Scanner;

/**
 * Interface utilisateur via ligne de commande.
 */
public class LigneCommande {

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

        System.out.println("Vos plantes vous remercient de les avoir arrosé.");

        System.out.println("Une représentation de mon jardin:");
        System.out.println(monJardin);

        scanner.close();
    }
}
