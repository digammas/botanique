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
        int n = scanner.nextInt();
        taille += n * 0.25;
        System.out.println("Taille après l'arrosage: " + taille + " cm.");

        System.out.println(nom + " vous remercie de l'avoir arrosé.");

        scanner.close();
    }
}
