import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
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
        public static void pagePlateau(JPanel panel, Class<?> callingClass) {
            /* -----------------------Panel principal------------------------ */
            panel.setLayout(new BorderLayout());

            /* -----------------------Panel du titre------------------------ */
            JPanel titrePanel = new JPanel();
            titrePanel.setBackground(AffichageInfo.couleurFond);
            AffichageInfo.labelTitrePlateau.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTitre));
            AffichageInfo.labelTitrePlateau.setForeground(Color.WHITE);
            titrePanel.add(AffichageInfo.labelTitrePlateau);
            panel.add(titrePanel, BorderLayout.NORTH);

            /* -----------------------Panel secondaire qui contient le panel qui affiche la tache a voter et celui des cartes et le bouton------------------------ */
            JPanel centrePanel = new JPanel();
            centrePanel.setLayout(new BoxLayout(centrePanel, BoxLayout.Y_AXIS));
            centrePanel.setBackground(AffichageInfo.couleurFond);

            // Ajoutez un espace vertical
            centrePanel.add(Box.createRigidArea(new Dimension(0, AffichageInfo.screenHeight/20))); // Ajustez la hauteur de l'espace selon vos besoins

            /* -----------------------Panel pour ecrire la tache a juger------------------------ */
            JPanel phrasePanel = new JPanel();
            phrasePanel.setBackground(AffichageInfo.couleurFond);
            JLabel phraseTextLabel = new JLabel("Votre phrase ici sur plusieurs lignes.");
            phraseTextLabel.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
            phraseTextLabel.setForeground(Color.WHITE);
            phrasePanel.add(phraseTextLabel);
            centrePanel.add(phrasePanel);

            System.out.println(AffichageInfo.screenHeight);
            // Ajoutez un espace vertical
           // centrePanel.add(Box.createRigidArea(new Dimension(0, AffichageInfo.screenHeight/20))); // Ajustez la hauteur de l'espace selon vos besoins

            /* -----------------------Panel des cartes------------------------ */
            JPanel cartesPanel = new JPanel();
            cartesPanel.setBackground(AffichageInfo.couleurFond);

            // Ajoute les cartes
            try {
                AffichageInfo.carte_0 = ImageIO.read(Objects.requireNonNull(callingClass.getResource("/images/carte_0.jpg")));
                AffichageInfo.carte_1 = ImageIO.read(Objects.requireNonNull(callingClass.getResource("/images/carte_1.jpg")));
                AffichageInfo.carte_2 = ImageIO.read(Objects.requireNonNull(callingClass.getResource("/images/carte_2.jpg")));
                AffichageInfo.carte_3 = ImageIO.read(Objects.requireNonNull(callingClass.getResource("/images/carte_3.jpg")));
                AffichageInfo.carte_5 = ImageIO.read(Objects.requireNonNull(callingClass.getResource("/images/carte_5.jpg")));
                AffichageInfo.carte_8 = ImageIO.read(Objects.requireNonNull(callingClass.getResource("/images/carte_8.jpg")));
                AffichageInfo.carte_13 = ImageIO.read(Objects.requireNonNull(callingClass.getResource("/images/carte_13.jpg")));
                AffichageInfo.carte_20 = ImageIO.read(Objects.requireNonNull(callingClass.getResource("/images/carte_20.jpg")));
                AffichageInfo.carte_40 = ImageIO.read(Objects.requireNonNull(callingClass.getResource("/images/carte_40.jpg")));
                AffichageInfo.carte_100 = ImageIO.read(Objects.requireNonNull(callingClass.getResource("/images/carte_100.jpg")));
                AffichageInfo.carte_cafe = ImageIO.read(Objects.requireNonNull(callingClass.getResource("/images/carte_cafe.jpg")));
                AffichageInfo.carte_interro = ImageIO.read(Objects.requireNonNull(callingClass.getResource("/images/carte_interro.jpg")));

                // Redimensionnez l'image à la largeur souhaitée
                int largeurRedimensionnee = AffichageInfo.screenWidth/13;
                int hauteurRedimensionnee = -1;
                Image carteRedimensionnee0 = AffichageInfo.carte_0.getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);
                Image carteRedimensionnee1 = AffichageInfo.carte_1.getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);
                Image carteRedimensionnee2 = AffichageInfo.carte_2.getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);
                Image carteRedimensionnee3 = AffichageInfo.carte_3.getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);
                Image carteRedimensionnee5 = AffichageInfo.carte_5.getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);
                Image carteRedimensionnee8 = AffichageInfo.carte_8.getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);
                Image carteRedimensionnee13 = AffichageInfo.carte_13.getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);
                Image carteRedimensionnee20 = AffichageInfo.carte_20.getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);
                Image carteRedimensionnee40 = AffichageInfo.carte_40.getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);
                Image carteRedimensionnee100 = AffichageInfo.carte_100.getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);
                Image carteRedimensionneecafe = AffichageInfo.carte_cafe.getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);
                Image carteRedimensionneeinterro = AffichageInfo.carte_interro.getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);

                AffichageInfo.labelCarte0 = new JLabel(new ImageIcon(carteRedimensionnee0));
                AffichageInfo.labelCarte0.putClientProperty("valeur", "0");
                AffichageInfo.labelCarte0.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                AffichageInfo.labelCarte1 = new JLabel(new ImageIcon(carteRedimensionnee1));
                AffichageInfo.labelCarte1.putClientProperty("valeur", "1");
                AffichageInfo.labelCarte1.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                AffichageInfo.labelCarte2 = new JLabel(new ImageIcon(carteRedimensionnee2));
                AffichageInfo.labelCarte2.putClientProperty("valeur", "2");
                AffichageInfo.labelCarte2.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                AffichageInfo.labelCarte3 = new JLabel(new ImageIcon(carteRedimensionnee3));
                AffichageInfo.labelCarte3.putClientProperty("valeur", "3");
                AffichageInfo.labelCarte3.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                AffichageInfo.labelCarte5 = new JLabel(new ImageIcon(carteRedimensionnee5));
                AffichageInfo.labelCarte5.putClientProperty("valeur", "5");
                AffichageInfo.labelCarte5.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                AffichageInfo.labelCarte8 = new JLabel(new ImageIcon(carteRedimensionnee8));
                AffichageInfo.labelCarte8.putClientProperty("valeur", "8");
                AffichageInfo.labelCarte8.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                AffichageInfo.labelCarte13 = new JLabel(new ImageIcon(carteRedimensionnee13));
                AffichageInfo.labelCarte13.putClientProperty("valeur", "13");
                AffichageInfo.labelCarte13.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                AffichageInfo.labelCarte20 = new JLabel(new ImageIcon(carteRedimensionnee20));
                AffichageInfo.labelCarte20.putClientProperty("valeur", "20");
                AffichageInfo.labelCarte20.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                AffichageInfo.labelCarte40 = new JLabel(new ImageIcon(carteRedimensionnee40));
                AffichageInfo.labelCarte40.putClientProperty("valeur", "40");
                AffichageInfo.labelCarte40.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                AffichageInfo.labelCarte100 = new JLabel(new ImageIcon(carteRedimensionnee100));
                AffichageInfo.labelCarte100.putClientProperty("valeur", "100");
                AffichageInfo.labelCarte100.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                AffichageInfo.labelCarteCafe = new JLabel(new ImageIcon(carteRedimensionneecafe));
                AffichageInfo.labelCarteCafe.putClientProperty("valeur", "cafe");
                AffichageInfo.labelCarteCafe.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                AffichageInfo.labelCarteInterro = new JLabel(new ImageIcon(carteRedimensionneeinterro));
                AffichageInfo.labelCarteInterro.putClientProperty("valeur", "interro");
                AffichageInfo.labelCarteInterro.setBorder(BorderFactory.createLineBorder(Color.RED, 2));

                cartesPanel.add(AffichageInfo.labelCarte0);
                cartesPanel.add(AffichageInfo.labelCarte1);
                cartesPanel.add(AffichageInfo.labelCarte2);
                cartesPanel.add(AffichageInfo.labelCarte3);
                cartesPanel.add(AffichageInfo.labelCarte5);
                cartesPanel.add(AffichageInfo.labelCarte8);
                cartesPanel.add(AffichageInfo.labelCarte13);
                cartesPanel.add(AffichageInfo.labelCarte20);
                cartesPanel.add(AffichageInfo.labelCarte40);
                cartesPanel.add(AffichageInfo.labelCarte100);
                cartesPanel.add(AffichageInfo.labelCarteCafe);
                cartesPanel.add(AffichageInfo.labelCarteInterro);

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
}
