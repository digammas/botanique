package com.acme.botanique.ihm;

import com.acme.botanique.Jardin;
import com.acme.botanique.Plante;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Interface utilisateur graphique pour le jardin botanique.
 */
public class ApplicationJardinBotanique extends Application {

    /**
     * Point d'entré de l'interface graphique.
     *
     * @param args  liste d'arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Définir le titre
        primaryStage.setTitle("Jardin Botanique");
        // Création d'un objet du type Jardin
        Jardin monJardin = new Jardin();
        // Création d'un label bienvenue
        Label labelBienvenue = new Label("Bienvenue dans ce jardin botanique.");
        // Création d'une mise en page de type pile verticale
        VBox pile = new VBox();
        // Centraliser la mise en page
        pile.setAlignment(Pos.CENTER);
        // Définir l'espacement verticale de la pile
        pile.setSpacing(20);
        // Ajout du label bienvenue
        pile.getChildren().add(labelBienvenue);
        // Création d'un panneau avec une mise en page de type grille
        GridPane grille = new GridPane();
        // Centraliser les éléments à l'interieur du panneau
        grille.setAlignment(Pos.CENTER);
        // Définir l'espacement horizontal
        grille.setHgap(10);
        // Définir l'espacement vertical
        grille.setVgap(10);
        // Définir un compteur de lignes
        int ligne = 0;
        for (Plante plante: monJardin.lirePlantes()) {
            // Création d'un label contenant le nom de la plante
            Text texteNom = new Text(plante.lireNom());
            // Sous-ligner le nom de la plante
            texteNom.setUnderline(true);
            // Création d'un label contenant la représentation de la plante
            Text textePlante = new Text(plante.toString());
            // Ajout du nom de la plante à la première colonne
            grille.add(texteNom, 0, ligne);
            // Ajout de la représentation de la plante à la deuxième colonne
            grille.add(textePlante, 1, ligne);
            // Augmentation du numéro de ligne
            ligne++;
        }
        // Ajouter la grille à la fin de pile
        pile.getChildren().add(grille);
        // Création et affectation de la scène
        primaryStage.setScene(new Scene(pile, 600, 300));
        // Affichage de la fenêtre
        primaryStage.show();
    }
}
