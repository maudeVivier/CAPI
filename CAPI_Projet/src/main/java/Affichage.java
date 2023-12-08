import java.awt.*;
import javax.swing.*;

/**
 * @file Affichage.java
 * @brief Contient les méthodes pour afficher différentes pages de l'interface graphique du jeu "Planning Poker".
 */

/**
 * @class Affichage
 * @brief Classe statique contenant les méthodes pour afficher différentes pages de l'interface graphique.
 *
 * Cette classe offre des méthodes pour afficher les différents affichages et la gestion des éléments d'interface utilisateur.
 */

public class Affichage {
    /**
     * Affiche la page d'accueil avec un panneau spécifié.
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
     * Affiche la page pour spécifier le nombre de joueurs avec un panneau spécifié.
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
     * Affiche la page pour la saisie des pseudos des joueurs avec un panneau spécifié.
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
     * Initialise les composants nécessaires pour la saisie des pseudos des joueurs dans un panneau spécifié.
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
     * Affiche la page de choix du mode de jeu avec un panneau spécifié.
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
        JLabel labelExplicatif = new JLabel("<html>Règles :"
                + "<br>Mode Unanimité : Les joueurs votent jusqu'à l'unanimité."
                + "<br>Mode Moyenne : Utilisation de la moyenne à partir du deuxième tour."
                + "</html>");
        labelExplicatif.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
        labelExplicatif.setForeground(Color.WHITE);
        labelExplicatif.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(labelExplicatif);

        panel.setBackground(AffichageInfo.couleurFond);
        panel.setPreferredSize(new Dimension(AffichageInfo.screenWidth, AffichageInfo.screenHeight));
    }

    /**
     * Affiche la page du plateau de jeu avec un panneau spécifié.
     * Cette méthode configure le panneau avec différents éléments.
     *
     * @param panel Le panneau sur lequel afficher la page du plateau de jeu.
     */
    public static void pagePlateau(JPanel panel){
        /* -----------------------Panel principal------------------------ */
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        AffichageInfo.labelTitrePlateau.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTitre));
        AffichageInfo.labelTitrePlateau.setForeground(Color.WHITE);
        AffichageInfo.labelTitrePlateau.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(AffichageInfo.labelTitrePlateau);


        panel.setBackground(AffichageInfo.couleurFond);
        panel.setPreferredSize(new Dimension(AffichageInfo.screenWidth, AffichageInfo.screenHeight));
    }
}
