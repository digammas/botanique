import java.util.Scanner;

/**
 * Classe principale.
 */
public class Jardin {

    public static void main(String[] args) {
        System.out.println("Bonjour Jardin!");
        double taille = 30; // Taille de plante en CM
        System.out.println("Taille initiale de plante: " + taille + " cm.");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Comment s'appelle-t-elle votre plante?");
        String nom = scanner.nextLine();

        // Arroser la plante
        System.out.println("Combien de fois voulez-vous arroser la plante?");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Désolé, je n'ai pas compris. Veuillez renseigner à un chiffre entier.");
        }
        int n = scanner.nextInt();
        taille += n * 0.25;

        System.out.println("Quelle unité voulez-vous utiliser pour l'affichage?");
        System.out.println("Renseigner 1 pour CM et 2 pour pouce.");
        int unite = scanner.nextInt();
        if (unite == 1) {
            System.out.println("Taille après l'arrosage: " + taille + " cm.");
        } else if (unite == 2) {
            double tailleEnPouce = taille * 0.393701;
            System.out.println("Taille après l'arrosage: " + tailleEnPouce + " pouce.");
        } else {
            System.out.println("Désolé, je n'ai pas compris votre choix.");
        }
        System.out.println(nom + " vous remercie de l'avoir arrosé.");

        scanner.close();
    }
}
