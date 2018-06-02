import java.util.Scanner;

/**
 * Classe principale.
 */
public class Jardin {

    public static void main(String[] args) {
        System.out.println("Bonjour Jardin!");
        // Tailles des plantes en CM
        double[] tailles = new double[] {30, 20, 45};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Comment s'appelle-t-elle votre bouquet?");
        String nom = scanner.nextLine();

        // Arroser la plante
        System.out.println("Combien de fois voulez-vous arroser la plante?");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Désolé, je n'ai pas compris. Veuillez renseigner à un chiffre entier.");
        }
        int n = scanner.nextInt();

        for (int i = 0; i < tailles.length; i++) {
            tailles[i] += n * 0.25;
        }

        System.out.println("Quelle unité voulez-vous utiliser pour l'affichage?");
        String unite = scanner.next();

        for (double taille : tailles) {
            afficher(taille, unite);
        }
        System.out.println(nom + " vous remercie de l'avoir arrosé.");

        scanner.close();
    }

    private static void afficher(double taille, String unite) {
        switch (unite.toLowerCase()) {
        case "cm":
            System.out.println("Taille après l'arrosage: " + taille + " cm.");
            break;
        case "pouce":
            double tailleEnPouce = taille * 0.393701;
            System.out.println("Taille après l'arrosage: " + tailleEnPouce + " pouce.");
            break;
        default:
            System.out.println("Désolé, je ne connais pas " + unite + " comme unité!");
        }
    }
}
