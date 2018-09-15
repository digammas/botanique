package com.acme.botanique.ihm;

import com.acme.botanique.ArrosageException;
import com.acme.botanique.Jardin;
import com.acme.botanique.Plante;
import com.acme.outils.Mesure;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Interface utilisateur graphique pour le jardin botanique.
 */
public class ApplicationJardinBotanique extends Application {

    /**
     * Une grille d'affichage.
     */
    private GridPane grille;

    /**
     * Configuration d'affichage.
     */
    private ConfigAffichage configAffichage = new ConfigAffichage();

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
        VBox pile = creerPile();
        // Ajout du label bienvenue
        pile.getChildren().add(labelBienvenue);
        // Création d'un panneau avec une mise en page de type grille
        this.grille = creerGrille();
        // Afficher les plantes
        afficherPlante(monJardin);
        // Ajouter la grille à la fin de pile
        pile.getChildren().add(grille);
        // Création d'une mise en page de type panneau horizontal
        HBox panneau = creerPanneau();
        // Création d'un bouton d'arrosage
        Button boutonArrosage = new Button("Arroser");
        // Création d'une boîte de dialogue
        TextInputDialog dialogueArrosage = creerDialogueArrosage();
        // Définition de l'acction du bouton : afficher le dialogue d'arrosage
        boutonArrosage.setOnAction(event -> arroser(monJardin, dialogueArrosage));
        // Ajout du bouton au panneau
        panneau.getChildren().add(boutonArrosage);
        // Création d'un bouton de configuration
        Button boutonConfig = new Button("Configurer");
        // Définition de l'acction du bouton : configurer l' affichage
        boutonConfig.setOnAction(event -> configurer(monJardin));
        // Ajout du bouton au panneau
        panneau.getChildren().add(boutonConfig);
        // Création d'un bouton pour quitter l'application
        Button boutonQuitter = new Button("Quitter");
        // Définition de l'acction du bouton : quitter l'application
        boutonQuitter.setOnAction(event -> primaryStage.close());
        // Ajout du bouton au panneau
        panneau.getChildren().add(boutonQuitter);
        // Ajout de panneau de bouton à la fin de pile
        pile.getChildren().add(panneau);
        // Création et affectation de la scène
        primaryStage.setScene(new Scene(pile, 600, 300));
        // Affichage de la fenêtre
        primaryStage.show();
    }

    /**
     * Essayer d'arroser le jardin en utilisant la boîte de dialogue.
     *
     * @param jardin    un jardin
     * @param dialog    une boîte de dialogue
     */
    private void arroser(Jardin jardin, TextInputDialog dialog) {
        // Afficher le dialogue
        dialog.showAndWait();
        // Obtenir le résultat
        String resultat = dialog.getResult();
        // Si le dialogue a été annulé, ne rien faire
        if (resultat == null) {
            return;
        }
        // Un message d'erreur
        String erreur = null;
        try {
            int n = Integer.parseInt(resultat);
            jardin.arroser(n);
        } catch (NumberFormatException e) {
            // Une valeur textuelle non numérique a été fournie
            erreur = "Une valeur entier est attendue!";
        } catch (ArrosageException e) {
            // Une valeur négative a été fournie
            erreur = e.getMessage();
        }
        if (erreur == null) {
            // Si aucune erreur, afficher les plantes après arrosage
            afficherPlante(jardin);
        } else {
            // Si une erreur s'est produite, afficher le message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR, erreur);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    /**
     * Configurer l'affichage.
     *
     * @param jardin            Le jardin à afficher
     */
    private void configurer(Jardin jardin) {
        // Dupliquer la config, c'est nécessaire car le dialogue peut être annulé
        ConfigAffichage nouvelleConfig = this.configAffichage.clone();
        // Création de dialogue de configuration
        Dialog<ButtonType> dialogueConfig = creerDialogueConfiguration(nouvelleConfig);
        // Seulement si le bouton cliqué est OK
        if (dialogueConfig.showAndWait().filter(ButtonType.OK::equals).isPresent()) {
            this.configAffichage = nouvelleConfig;
            afficherPlante(jardin);
        }
    }

    /**
     * Afficher les plantes du jardin sur la grille d'affichage.
     *
     * @param jardin    le jardin contenant des plantes
     */
    private void afficherPlante(Jardin jardin) {
        // Supprimer toutes les lignes de la grille
        this.grille.getChildren().clear();
        // Définir un compteur de lignes, on commence à la première ligne
        int ligne = 0;
        for (Plante plante: jardin.lirePlantes()) {
            // Création d'un label contenant le nom de la plante
            Text texteNom = new Text(plante.lireNom());
            // Sous-ligner le nom de la plante
            texteNom.setUnderline(true);
            // Création d'un label contenant la représentation de la plante
            Text textePlante = new Text(plante.toString());
            // Ajout du nom de la plante à la première colonne
            this.grille.add(texteNom, 0, ligne);
            // Ajout de la représentation de la plante à la deuxième colonne
            this.grille.add(textePlante, 1, ligne);
            // S'il faut, afficher la taille
            if (this.configAffichage.lireAfficherTaille()) {
                // Convertir en pouce s'il faut
                double taille = plante.lireTaille();
                if (this.configAffichage.lireAfficherEnPouce()) {
                    taille = Mesure.convertir(taille, Mesure.CM_A_POUCE);
                }
                // Création d'un label contenant la taille de la plante
                Text texteTaille = new Text(String.format("%.2f", taille));
                this.grille.add(texteTaille, 2, ligne);
            }
            // Augmentation du numéro de ligne
            ligne++;
        }
    }

    /**
     * Créer un panneau avec une mise en page type pile verticale
     *
     * @return  une pile d'affichage
     */
    private static VBox creerPile() {
        VBox pile = new VBox();
        // Centraliser la mise en page
        pile.setAlignment(Pos.CENTER);
        // Définir l'espacement verticale de la pile
        pile.setSpacing(20);
        return pile;
    }

    /**
     * Créer un panneau avec une mise en page type pile horizontale
     *
     * @return  un panneau d'affichage
     */
    private static HBox creerPanneau() {
        HBox panneau = new HBox();
        // Centraliser la mise en page
        panneau.setAlignment(Pos.CENTER);
        // Définir l'espacement verticale de la pile
        panneau.setSpacing(20);
        return panneau;
    }

    /**
     * Créer un panneau avec une mise en page type grille.
     *
     * @return  une grille d'affichage
     */
    private static GridPane creerGrille() {
        GridPane grille = new GridPane();
        // Centraliser les éléments à l'interieur du panneau
        grille.setAlignment(Pos.CENTER);
        // Définir l'espacement horizontal
        grille.setHgap(10);
        // Définir l'espacement vertical
        grille.setVgap(10);
        return grille;
    }


    /**
     * Créer une boîte de dialogue d'arrosage.
     *
     * @return  boîte de dialoge d'arrosage
     */
    private static TextInputDialog creerDialogueArrosage() {
        TextInputDialog dialogueArrosage = new TextInputDialog();
        // Définir le titre de la boîte
        dialogueArrosage.setTitle("Arrosage des plante");
        // Définir le texte du message
        dialogueArrosage.setContentText("Quantité d'arrosage");
        // Le dialogue n'a pas d'entête
        dialogueArrosage.setHeaderText(null);
        return dialogueArrosage;
    }

    private static Dialog<ButtonType> creerDialogueConfiguration(ConfigAffichage config) {
        Dialog<ButtonType> dialogue = new Dialog<>();
        dialogue.setTitle("Configuration d'affichage");
        dialogue.setHeaderText(null);
        dialogue.getDialogPane().getButtonTypes().setAll(ButtonType.OK, ButtonType.CANCEL);
        CheckBox choixTaille = new CheckBox();
        CheckBox choixUnite = new CheckBox();
        Label labelUnite = new Label("Afficher la taille en pouce.");
        GridPane grille = new GridPane();
        grille.setHgap(10);
        grille.setVgap(10);
        grille.setPadding(new Insets(25, 30, 10, 30));
        // Initialiser les contrôles
        choixTaille.setSelected(config.lireAfficherTaille());
        choixUnite.setDisable(!config.lireAfficherTaille());
        choixUnite.setSelected(config.lireAfficherEnPouce());
        labelUnite.setDisable(!config.lireAfficherTaille());
        // Définir les gestionnaire
        choixTaille.setOnAction(event -> {
            boolean afficherTaille = choixTaille.isSelected();
            config.ecrireAfficherTaille(afficherTaille);
            choixUnite.setDisable(!afficherTaille);
            labelUnite.setDisable(!afficherTaille);
        });
        choixUnite.setOnAction(event -> config.ecrireAfficherEnPouce(choixTaille.isSelected()));
        // Ajouter les contrôles
        grille.add(choixTaille, 0, 0);
        grille.add(new Label("Afficher la taille des plante."), 1, 0);
        grille.add(choixUnite, 0, 1);
        grille.add(labelUnite, 1, 1);
        dialogue.getDialogPane().setContent(grille);
        return dialogue;
    }
}
