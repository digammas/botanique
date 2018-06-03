package com.acme.botanique;

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

    @Override
    public String toString() {
        return plantes.length + " plantes.";
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

        System.out.println("Vos plantes vous remercient de les avoir arrosé.");

        System.out.println("Une représentation de mon jardin:");
        System.out.println(monJardin);

        scanner.close();
    }
}
