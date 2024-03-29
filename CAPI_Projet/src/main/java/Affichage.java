/**
 * @file Affichage.java
 * @brief Contient les méthodes pour afficher différentes pages de l'interface graphique.
 */
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

/**
 * @class Affichage
 * @brief Classe statique contenant les méthodes pour afficher différentes pages de l'interface graphique.
 *
 * Cette classe offre des méthodes pour afficher les différents affichages et la gestion des éléments d'interface utilisateur.
 */

public class Affichage {
    /**
     * @brief Affiche la page d'accueil avec un panneau spécifié.
     * Cette méthode configure le panneau avec un titre, des boutons et des espaces verticaux.
     *
     * @param panel Le panneau sur lequel afficher la page d'accueil.
     */
    public static void pageAccueil(JPanel panel){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // Titre
        AffichageInfo.labelTitreAccueil.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTitre));
        AffichageInfo.labelTitreAccueil.setForeground(Color.WHITE);
        AffichageInfo.labelTitreAccueil.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(AffichageInfo.labelTitreAccueil);

        // Ajouter un espace vertical
        panel.add(Box.createVerticalStrut(AffichageInfo.screenHeight / 4));

        // Bouton
        AffichageInfo.boutonNouvellePartie.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
        AffichageInfo.boutonNouvellePartie.setBackground(Color.darkGray);
        AffichageInfo.boutonNouvellePartie.setForeground(Color.WHITE);
        AffichageInfo.boutonNouvellePartie.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(AffichageInfo.boutonNouvellePartie);

        // Ajouter un espace vertical
        panel.add(Box.createVerticalStrut(AffichageInfo.screenHeight / 10));

        AffichageInfo.boutonReprendrePartie.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
        AffichageInfo.boutonReprendrePartie.setBackground(Color.darkGray);
        AffichageInfo.boutonReprendrePartie.setForeground(Color.WHITE);
        AffichageInfo.boutonReprendrePartie.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(AffichageInfo.boutonReprendrePartie);

        panel.setBackground(AffichageInfo.couleurFond);
        panel.setPreferredSize(new Dimension(AffichageInfo.screenWidth, AffichageInfo.screenHeight));
    }

    /**
     * @brief Affiche la page pour spécifier le nombre de joueurs avec un panneau spécifié.
     * Cette méthode configure le panneau avec différents éléments.
     *
     * @param panel Le panneau sur lequel afficher la page pour spécifier le nombre de joueurs.
     */
    public static void pageNbPerso(JPanel panel){
        /* -----------------------Panel principal------------------------ */
        panel.setLayout(new BorderLayout());

        AffichageInfo.labelTitreNbJoueur.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTitre));
        AffichageInfo.labelTitreNbJoueur.setForeground(Color.white);
        AffichageInfo.labelTitreNbJoueur.setHorizontalAlignment(JLabel.CENTER);
        // Ajouter un label à la première ligne
        panel.add(AffichageInfo.labelTitreNbJoueur, BorderLayout.NORTH);

        /* -----------------------Panel secondaire------------------------ */
        // composants center et espacés de pixels en horizontal et pixels vertical
        JPanel sousPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, AffichageInfo.screenWidth/51, AffichageInfo.screenHeight/28));

        // Ajouter trois labels au sous-panneau (deuxième ligne)
        AffichageInfo.labelNbJoueur.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
        AffichageInfo.labelNbJoueur.setForeground(Color.white);
        sousPanel.add(AffichageInfo.labelNbJoueur);

        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) AffichageInfo.spinnerNbJoueur.getEditor();
        editor.getTextField().setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
        AffichageInfo.spinnerNbJoueur.setEnabled(true);
        sousPanel.add(AffichageInfo.spinnerNbJoueur);

        AffichageInfo.boutonValiderNbJoueur.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
        AffichageInfo.boutonValiderNbJoueur.setBackground(Color.darkGray);
        AffichageInfo.boutonValiderNbJoueur.setForeground(Color.WHITE);
        sousPanel.add(AffichageInfo.boutonValiderNbJoueur);

        // Ajouter du vide autour du sous-panneau pour créer de l'espace
        sousPanel.setBorder(BorderFactory.createEmptyBorder(AffichageInfo.screenHeight/5, 0, AffichageInfo.screenHeight/8, 0));
        sousPanel.setBackground(AffichageInfo.couleurFond);

        // Ajouter le conteneur extérieur au panneau principal
        panel.add(sousPanel, BorderLayout.CENTER);

        panel.setBackground(AffichageInfo.couleurFond);
        panel.setPreferredSize(new Dimension(AffichageInfo.screenWidth, AffichageInfo.screenHeight));
    }

    /**
     * @brief Affiche la page pour la saisie des pseudos des joueurs avec un panneau spécifié.
     * Cette méthode configure le panneau avec différents éléments.
     *
     * @param panel Le panneau sur lequel afficher la page de saisie des pseudos.
     */
    public static void pagePseudoPerso(JPanel panel) {
        /* -----------------------Panel principal------------------------ */
        panel.setLayout(new BorderLayout());

        AffichageInfo.labelTitrePseudoJoueur.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTitre));
        AffichageInfo.labelTitrePseudoJoueur.setForeground(Color.WHITE);
        AffichageInfo.labelTitrePseudoJoueur.setHorizontalAlignment(JLabel.CENTER);

        // Ajoutez le titre centré en haut du BorderLayout
        panel.add(AffichageInfo.labelTitrePseudoJoueur, BorderLayout.NORTH);

        /* -----------------------Panel textArea des pseudos------------------------ */
        JPanel textAreaPanel = new JPanel();
        initialiserComposants(textAreaPanel);

        textAreaPanel.setBackground(AffichageInfo.couleurFond);
        textAreaPanel.setLayout(new FlowLayout(FlowLayout.LEFT, AffichageInfo.screenWidth/31, AffichageInfo.screenHeight/12));

        textAreaPanel.setBorder(BorderFactory.createEmptyBorder(AffichageInfo.screenHeight/17, AffichageInfo.screenHeight/76, AffichageInfo.screenHeight/28, AffichageInfo.screenHeight/76));

        // Ajoutez le panneau de JTextArea au centre du BorderLayout
        panel.add(textAreaPanel);

        /* -----------------------Panel bouton valider pseudo------------------------ */
        JPanel boutonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, AffichageInfo.screenWidth/76, AffichageInfo.screenHeight/4)); // Utilisez FlowLayout pour le bouton
        AffichageInfo.boutonValiderPseudo.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
        AffichageInfo.boutonValiderPseudo.setBackground(Color.darkGray);
        AffichageInfo.boutonValiderPseudo.setForeground(Color.WHITE);

        boutonPanel.setBackground(AffichageInfo.couleurFond);
        boutonPanel.add(AffichageInfo.boutonValiderPseudo);

        // Ajoutez le panneau de bouton à droite du BorderLayout
        panel.add(boutonPanel, BorderLayout.EAST);

        panel.setBackground(AffichageInfo.couleurFond);
        panel.setPreferredSize(new Dimension(AffichageInfo.screenWidth, AffichageInfo.screenHeight));
    }

    /**
     * @brief Initialise les composants nécessaires pour la saisie des pseudos des joueurs dans un panneau spécifié.
     * Pour chaque joueur, un label indiquant le numéro du joueur et un JTextArea pour saisir le pseudo sont créés.
     *
     * @param panel Le panneau sur lequel initialiser les composants pour la saisie des pseudos.
     */
    public static void initialiserComposants(JPanel panel) {
        AffichageInfo.areaTabPseudo = new JTextArea[AffichageInfo.nbJoueur];

        for (int i = 0; i < AffichageInfo.nbJoueur; i++) {
            JTextArea areaPseudo = new JTextArea(1, AffichageInfo.screenWidth/76);
            areaPseudo.setFont(new Font("Arial", Font.BOLD, AffichageInfo.sizeTexte));

            String nom = "Joueur " + (i+1) + " : ";
            JLabel labelPseudo = new JLabel(nom);
            labelPseudo.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
            labelPseudo.setForeground(Color.WHITE);

            // Ajoutez le label puis le JTextArea au panneau
            panel.add(labelPseudo);
            panel.add(areaPseudo);

            AffichageInfo.areaTabPseudo[i] = areaPseudo;
        }
    }

    /**
     * @brief  Affiche la page de choix du mode de jeu avec un panneau spécifié.
     * Cette méthode configure le panneau avec différents éléments.
     *
     * @param panel Le panneau sur lequel afficher la page de choix du mode de jeu.
     */
    public static void pageChoixMode(JPanel panel){
        /* -----------------------Panel principal------------------------ */
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        AffichageInfo.labelTitreMode.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTitre));
        AffichageInfo.labelTitreMode.setForeground(Color.WHITE);
        AffichageInfo.labelTitreMode.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(AffichageInfo.labelTitreMode);

        // Ajouter un espace vertical
        panel.add(Box.createVerticalStrut(AffichageInfo.screenHeight / 5));

        // Checkbox
        AffichageInfo.checkUnanimate.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
        AffichageInfo.checkUnanimate.setBackground(AffichageInfo.couleurFond);
        AffichageInfo.checkUnanimate.setForeground(Color.WHITE);
        AffichageInfo.checkUnanimate.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(AffichageInfo.checkUnanimate);

        panel.add(Box.createVerticalStrut(AffichageInfo.screenHeight / 76));

        AffichageInfo.checkMoyenne.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
        AffichageInfo.checkMoyenne.setBackground(AffichageInfo.couleurFond);
        AffichageInfo.checkMoyenne.setForeground(Color.WHITE);
        AffichageInfo.checkMoyenne.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(AffichageInfo.checkMoyenne);

        // Ajouter un espace vertical
        panel.add(Box.createVerticalStrut(AffichageInfo.screenHeight / 5));

        // Bouton
        AffichageInfo.boutonValiderMode.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
        AffichageInfo.boutonValiderMode.setBackground(Color.darkGray);
        AffichageInfo.boutonValiderMode.setForeground(Color.WHITE);
        AffichageInfo.boutonValiderMode.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(AffichageInfo.boutonValiderMode);

        // Ajouter un espace vertical
        panel.add(Box.createVerticalStrut(AffichageInfo.screenHeight / 10));

        // Règles
        JLabel labelExplicatif = new JLabel("<html><center>Règles :"
                + "<br>Mode Unanimité : Les joueurs votent jusqu'à l'unanimité."
                + "<br>Mode Moyenne : Utilisation de la moyenne à partir du deuxième tour."
                + "</center></html>");
        labelExplicatif.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
        labelExplicatif.setForeground(Color.WHITE);
        labelExplicatif.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(labelExplicatif);

        panel.setBackground(AffichageInfo.couleurFond);
        panel.setPreferredSize(new Dimension(AffichageInfo.screenWidth, AffichageInfo.screenHeight));
    }

    /**
     * @brief Affiche la page pour écrire les fonctionnalités a voter avec un panneau spécifié.
     * Cette méthode configure le panneau avec différents éléments.
     *
     * @param panel Le panneau sur lequel afficher la page pour écrire les fonctionnalités.
     */
    public static void pageFonctionnalite(JPanel panel){
        /* -----------------------Panel principal------------------------ */
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        /* -----------------------Panel titre------------------------ */
        JPanel panelTitre = new JPanel();
        panelTitre.setBackground(AffichageInfo.couleurFond);
        AffichageInfo.labelTitreFonctionnalite.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTitre));
        AffichageInfo.labelTitreFonctionnalite.setForeground(Color.WHITE);
        panelTitre.add(AffichageInfo.labelTitreFonctionnalite);
        panel.add(panelTitre);

        /* -----------------------Panel pour ecrire et validees les fonctionnalites------------------------ */
        JPanel fieldPanel = new JPanel(new FlowLayout());
        fieldPanel.setBackground(AffichageInfo.couleurFond);

        //Espace pour ecrire la fonctionnalite
        fieldPanel.add(AffichageInfo.fieldFonctionnalite);

        // Bouton enregistrer la fonctionnalite ecrite
        AffichageInfo.boutonValiderFonctionnalite.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
        AffichageInfo.boutonValiderFonctionnalite.setBackground(Color.darkGray);
        AffichageInfo.boutonValiderFonctionnalite.setForeground(Color.WHITE);
        fieldPanel.add(AffichageInfo.boutonValiderFonctionnalite);
        panel.add(fieldPanel);

        /* -----------------------Panel pour voir les fonctionnalites deja validees------------------------ */
        JPanel scrollPanel = new JPanel(new FlowLayout());
        scrollPanel.setBackground(AffichageInfo.couleurFond);

        // Espace pour voir les fonctionnalites deja validées
        JScrollPane scrollPane = new JScrollPane(AffichageInfo.fonctionnalitesList);

        // Réduit la largeur de la barre de défilement
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(AffichageInfo.screenHeight/15, Integer.MAX_VALUE));

        scrollPanel.add(scrollPane);
        panel.add(scrollPanel);

        /* -----------------------Panel bouton pour aller sur le plateau------------------------ */
        JPanel panelBouton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBouton.setBackground(AffichageInfo.couleurFond);

        // Bouton quand on a fini d'ajouter les fonctionnalites, pour passer au plateau
        AffichageInfo.boutonPasserPlateau.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
        AffichageInfo.boutonPasserPlateau.setBackground(Color.darkGray);
        AffichageInfo.boutonPasserPlateau.setForeground(Color.WHITE);
        panelBouton.add(AffichageInfo.boutonPasserPlateau);
        panel.add(panelBouton);

        panel.setBackground(AffichageInfo.couleurFond);
        panel.setPreferredSize(new Dimension(AffichageInfo.screenWidth, AffichageInfo.screenHeight));

    }


    /**
     * @brief Affiche la page du plateau de jeu avec un panneau spécifié.
     * Cette méthode configure le panneau avec différents éléments.
     *
     * @param panel Le panneau sur lequel afficher la page du plateau de jeu.
     */
    public static void pagePlateau(JPanel panel) {
            /* -----------------------Panel principal------------------------ */
            panel.setLayout(new BorderLayout());

            /* -----------------------Panel du titre------------------------ */
            JPanel titrePanel = new JPanel();
            titrePanel.setBackground(AffichageInfo.couleurFond);
            AffichageInfo.labelTitrePlateau.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTitre));
            AffichageInfo.labelTitrePlateau.setForeground(Color.WHITE);
            titrePanel.add(AffichageInfo.labelTitrePlateau);
            panel.add(titrePanel, BorderLayout.NORTH);

            /* -----------------------Panel secondaire qui contient le panel qui affiche la fonctionnalite a voter et celui des cartes et le bouton------------------------ */
            JPanel centrePanel = new JPanel();
            centrePanel.setLayout(new BoxLayout(centrePanel, BoxLayout.Y_AXIS));
            centrePanel.setBackground(AffichageInfo.couleurFond);

            // Ajoutez un espace vertical
            //centrePanel.add(Box.createRigidArea(new Dimension(0, AffichageInfo.screenHeight/30)));

            /* -----------------------Panel pour ecrire la fonctionnalite a juger------------------------ */
            JPanel phrasePanel = new JPanel();
            phrasePanel.setBackground(AffichageInfo.couleurFond);
            AffichageInfo.labelRegle = new JLabel("<html><center>Fonctionnalité " + (AffichageInfo.fonctionnaliteVote+1) + "/" + AffichageInfo.nbFonctionnalite + " : "
                    + "<br>"
                    + Fonctionnalite.listeFonctionnalites.get(AffichageInfo.fonctionnaliteVote).getDescription()
                    + "</center></html>");
            AffichageInfo.labelRegle.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
            AffichageInfo.labelRegle.setForeground(Color.WHITE);
            phrasePanel.add(AffichageInfo.labelRegle);
            centrePanel.add(phrasePanel);

            /* -----------------------Panel pour ecrire le mode de jeu choisi et le nombre de tour------------------------ */
            JPanel modeEtTourPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            modeEtTourPanel.setBackground(AffichageInfo.couleurFond);
            AffichageInfo.labelModeEtTour = new JLabel("Mode de jeu : " + ReglesPlanningPoker.modeDeJeu + "         Tour : " + AffichageInfo.tour);
            AffichageInfo.labelModeEtTour.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
            AffichageInfo.labelModeEtTour.setForeground(Color.WHITE);
            modeEtTourPanel.add(AffichageInfo.labelModeEtTour);
            centrePanel.add(modeEtTourPanel);

            /* -----------------------Panel pour ecrire le mode de jeu choisi et le nombre de tour------------------------ */
            JPanel panelTimer = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelTimer.setBackground(AffichageInfo.couleurFond);
            AffichageInfo.labelTimer = new JLabel("Temps écoulé : " +  ChronoTemps.tempsPartie +" sec");
            AffichageInfo.labelTimer.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
            AffichageInfo.labelTimer.setForeground(Color.WHITE);
            panelTimer.add(AffichageInfo.labelTimer);
            centrePanel.add(panelTimer);

            /* -----------------------Panel pour ecrire le joueur qui vote------------------------ */
            JPanel pseudoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pseudoPanel.setBackground(AffichageInfo.couleurFond);
            AffichageInfo.labelPseudo = new JLabel("Joueur 1/ " + AffichageInfo.nbJoueur + " : "+ Joueur.listeJoueurs.get(0).getPseudo());
            AffichageInfo.labelPseudo.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
            AffichageInfo.labelPseudo.setForeground(Color.WHITE);
            pseudoPanel.add(AffichageInfo.labelPseudo);
            centrePanel.add(pseudoPanel);


            /* -----------------------Panel des cartes------------------------ */
            JPanel cartesPanel = new JPanel();
            cartesPanel.setBackground(AffichageInfo.couleurFond);

            // Ajoute les cartes
            try {

                // Chargez les images à partir du tableau de noms de fichiers
                for (int i = 0; i < AffichageInfo.nomFichiers.length; i++) {
                    String relativePath = "\\src\\images\\" + AffichageInfo.nomFichiers[i];

                    String absolutePath = AffichageInfo.workingDirectory + relativePath;

                    // Chargez l'image
                    AffichageInfo.carte[i] = ImageIO.read(new File(absolutePath));
                }


                // Créez un tableau pour stocker les images redimensionnées
                Image[] cartesRedimensionnees = new Image[AffichageInfo.carte.length];

                // Définissez la largeur de redimensionnement
                int largeurRedimensionnee = AffichageInfo.screenWidth / 13;
                int hauteurRedimensionnee = -1;

                // Parcourez le tableau d'images et redimensionnez-les
                for (int i = 0; i < AffichageInfo.carte.length; i++) {
                    if (AffichageInfo.carte[i] != null) {
                        Image carteRedimensionnee = AffichageInfo.carte[i].getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);
                        cartesRedimensionnees[i] = carteRedimensionnee;
                    } else {
                        System.err.println("La carte à l'indice " + i + " n'a pas été correctement initialisée.");
                    }
                }

                // Créez un tableau pour stocker les JLabels
                AffichageInfo.labelsCartes = new JLabel[AffichageInfo.valeursCartes.length];

                // Utilisez une boucle pour créer et configurer chaque JLabel
                for (int i = 0; i < AffichageInfo.valeursCartes.length; i++) {
                    Image carteRedimensionnee = cartesRedimensionnees[i];

                    // Créez un JLabel avec une ImageIcon
                    AffichageInfo.labelsCartes[i] = new JLabel(new ImageIcon(carteRedimensionnee));

                    // Configurez les propriétés spécifiques à chaque carte
                    AffichageInfo.labelsCartes[i].putClientProperty("valeur", AffichageInfo.valeursCartes[i]);
                    AffichageInfo.labelsCartes[i].setBorder(BorderFactory.createLineBorder(AffichageInfo.couleurFond, 2));

                    cartesPanel.add(AffichageInfo.labelsCartes[i]);
                }
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }

            centrePanel.add(cartesPanel);

            /* -----------------------Panel du bouton------------------------ */
            JPanel boutonPanel = new JPanel();
            boutonPanel.setBackground(AffichageInfo.couleurFond);
            AffichageInfo.boutonChoixCarte.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
            AffichageInfo.boutonChoixCarte.setBackground(Color.darkGray);
            AffichageInfo.boutonChoixCarte.setForeground(Color.WHITE);
            boutonPanel.add(AffichageInfo.boutonChoixCarte);

            centrePanel.add(boutonPanel);
            panel.add(centrePanel, BorderLayout.CENTER);

            panel.setBackground(AffichageInfo.couleurFond);
            panel.setPreferredSize(new Dimension(AffichageInfo.screenWidth, AffichageInfo.screenHeight));
        }

    /**
     * @brief Change la règle affichée sur la page du plateau de jeu en fonction de la fonctionnalité en cours.
     */
    public static void changerRegle(){
        int indexRegleCourante = (AffichageInfo.fonctionnaliteVote) % AffichageInfo.nbFonctionnalite;
        AffichageInfo.labelRegle.setText("<html><center> Fonctionnalité " + (indexRegleCourante + 1) + "/" + AffichageInfo.nbFonctionnalite + " : "
                + "<br>"
                + Fonctionnalite.listeFonctionnalites.get(indexRegleCourante).getDescription()
                + "</center></html>");
    }

    /**
     * @brief Change le pseudo affiché sur la page du plateau de jeu en fonction du joueur en cours.
     */
    public static void changerPseudo() {
        int indexPseudoCourant = (AffichageInfo.joueurVote) % Joueur.listeJoueurs.size();
        AffichageInfo.labelPseudo.setText("Joueur " + (indexPseudoCourant+1) + "/" + AffichageInfo.nbJoueur + " : " + Joueur.listeJoueurs.get(indexPseudoCourant).getPseudo());
    }

    /**
     * @brief Change le tour affiché sur la page du plateau de jeu.
     */
    public static void changerTour() {
        AffichageInfo.labelModeEtTour.setText("Mode de jeu : " + ReglesPlanningPoker.modeDeJeu + "         Tour : " + AffichageInfo.tour);
    }
}
