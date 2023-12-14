import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
            AffichageInfo.labelRegle = new JLabel("Votre phrase ici sur plusieurs lignes.");
            AffichageInfo.labelRegle.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
            AffichageInfo.labelRegle.setForeground(Color.WHITE);
            phrasePanel.add(AffichageInfo.labelRegle);
            centrePanel.add(phrasePanel);

            /* -----------------------Panel pour ecrire le joueur qui vote------------------------ */
            JPanel pseudoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pseudoPanel.setBackground(AffichageInfo.couleurFond);
            AffichageInfo.labelPseudo = new JLabel("Joueur : " + Joueur.listeJoueurs.get(0).getMonPseudo());
            AffichageInfo.labelPseudo.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
            AffichageInfo.labelPseudo.setForeground(Color.WHITE);
            pseudoPanel.add(AffichageInfo.labelPseudo);
            centrePanel.add(pseudoPanel);


            /* -----------------------Panel des cartes------------------------ */
            JPanel cartesPanel = new JPanel();
            cartesPanel.setBackground(AffichageInfo.couleurFond);

            // Ajoute les cartes
            try {

                // Obtenez le répertoire de travail actuel
                String workingDirectory = System.getProperty("user.dir");

                // Chargez les images à partir du tableau de noms de fichiers
                for (int i = 0; i < AffichageInfo.nomFichiers.length; i++) {
                    // Chemin relatif de la ressource par rapport au répertoire de travail
                    String relativePath = "\\src\\images\\" + AffichageInfo.nomFichiers[i];

                    // Concaténez les deux chemins pour obtenir le chemin absolu
                    String absolutePath = workingDirectory + relativePath;
                    //System.out.println("chemin " + absolutePath);

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
                    AffichageInfo.labelsCartes[i].setBorder(BorderFactory.createLineBorder(Color.RED, 2));

                    cartesPanel.add(AffichageInfo.labelsCartes[i]);
                }

                /*AffichageInfo.carte_0 = ImageIO.read(Objects.requireNonNull(callingClass.getResource("/images/carte_0.jpg")));

                // Redimensionnez l'image à la largeur souhaitée
                int largeurRedimensionnee = AffichageInfo.screenWidth/13;
                int hauteurRedimensionnee = -1;
                Image carteRedimensionnee0 = AffichageInfo.carte_0.getScaledInstance(largeurRedimensionnee, hauteurRedimensionnee, Image.SCALE_SMOOTH);

                AffichageInfo.labelCarte0 = new JLabel(new ImageIcon(carteRedimensionnee0));
                AffichageInfo.labelCarte0.putClientProperty("valeur", "0");
                AffichageInfo.labelCarte0.setBorder(BorderFactory.createLineBorder(Color.RED, 2));

                cartesPanel.add(AffichageInfo.labelCarte0);
;*/
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
