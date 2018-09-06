package com.acme.botanique.ihm;

import com.acme.botanique.ArrosageException;
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

        try {
            Jardin monJardin = new Jardin();

            String reponse;
            do {
                // Arroser la plante
                System.out.println("Combien de fois voulez-vous arroser les plantes?");
                while (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.println("Désolé, je n'ai pas compris. Veuillez renseigner à un chiffre entier.");
                }
                int n = scanner.nextInt();
                scanner.nextLine();

                try {
                    monJardin.arroser(n);
                } catch (ArrosageException e) {
                    System.err.println(e.getMessage());
                }

                System.out.println("Voulez-vous arrêter d'arroser les plantes?");
                reponse = scanner.nextLine();
            } while (!reponse.toLowerCase().equals("oui"));

            System.out.println("Vos plantes vous remercient de les avoir arrosé.");

            System.out.println("Une représentation de mon jardin:");
            System.out.println(monJardin);

            double valeurNutritionnelle = monJardin.calculerValeurNutritionnelle();
            System.out.printf("La valeur nutritionnelle totale de votre jardin est %.2f.", valeurNutritionnelle);
        } finally {
            scanner.close();
        }
    }
}
