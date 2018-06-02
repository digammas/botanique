import java.util.Scanner;

/**
 * Classe principale.
 */
public class Jardin {

    public static void main(String[] args) {
        System.out.println("Bonjour Jardin!");
        double taille = 30; // Taille de plante en CM
        System.out.println("Taille initiale de plante: " + taille + " cm.");
        // Arroser la plante
        taille += 0.25;
        System.out.println("Taille après l'arrosage: " + taille + " cm.");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Comment s'appelle-t-elle votre plante?");
        String nom = scanner.nextLine();
        System.out.println(nom + " vous remercie de l'avoir arrosé.");

        scanner.close();
    }
}
