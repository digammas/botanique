package com.acme.botanique.ihm;

import com.acme.botanique.Jardin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
        // Création d'un label contenant le texte représentatif du jardin
        Label labelJardin = new Label(monJardin.toString());
        // Création d'une mise en page de type pile verticale
        Pane pile = new VBox();
        // Ajout du label bienvenue
        pile.getChildren().add(labelBienvenue);
        // Ajout du label de la représentation du jardin
        pile.getChildren().add(labelJardin);
        // Création et affectation de la scène
        primaryStage.setScene(new Scene(pile, 600, 300));
        // Affichage de la fenêtre
        primaryStage.show();
    }
}
