import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * @file AffichageInfo.java
 * @brief Contient les informations d'affichage pour l'interface graphique.
 */

/**
 * @class AffichageInfo
 * @brief Classe statique contenant les informations d'affichage pour l'interface graphique.
 *
 * Cette classe stocke des paramètres tels que la dimension de l'écran, les tailles de police,
 * les tailles des boutons, des variables, des couleurs, des boutons, des spinners, des textareas,
 * des labels, et des checkboxes utilisés dans l'interface graphique du jeu "Planning Poker".
 */
public class AffichageInfo {
    /* --------------------Dimension de l'écran--------------------- */
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int screenWidth = (int) screenSize.getWidth();
    public static final int screenHeight = (int) screenSize.getHeight();

    /* --------------------Differentes tailles de police--------------------- */
    public static int sizeTitre = (int) (screenWidth * 0.059);
    public static int sizeTexte = (int) (screenWidth * 0.015);

    /* --------------------Differentes tailles pour les boutons--------------------- */
    public static int largeurBouton = screenWidth / 5;
    public static int hauteurBouton = (screenHeight / 10) - (screenHeight / 138);

    /* --------------------Différentes variables--------------------- */
    //nombre de joueur qui joue la partie
    public static int nbJoueur;

    //nombre de tour réalisé pour voter une regle
    public static int tour = 1;

    //pour savoir quel joueur est en train de voter
    public static int joueurVote = 0;

    //pour savoir quelle regle est en train de voter
    public static int regleVote = 0;

    // Liste des cartes votées pendant un tour
    public static List<String> cartesVotees = new ArrayList<>();

    /* --------------------Diiférentes variables pour savoir dans quel menu on est--------------------- */
    public static final int MENU_ACCUEIL = 0;
    public static final int MENU_NB_JOUEUR = 1;
    public static final int MENU_PSEUDO = 2;
    public static final int MENU_MODE = 3;
    public static final int MENU_FONCTIONNALITE = 4;
    public static final int MENU_PLATEAU = 5;
    /* --------------------Couleurs--------------------- */
    public static Color couleurFond = new Color(0, 0, 50);

    /* --------------------Differents boutons--------------------- */
    public static JButton boutonNouvellePartie = new JButton("Nouvelle Partie");
    public static JButton boutonReprendrePartie = new JButton("Reprendre la partie");
    public static JButton boutonValiderNbJoueur = new JButton("Valider");
    public static JButton boutonValiderPseudo = new JButton("Valider");
    public static JButton boutonValiderMode = new JButton("Valider");
    public static JButton boutonValiderTache = new JButton("Valider");
    public static JButton boutonPasserPlateau = new JButton("Commencer a voter");
    public static JButton boutonSauvegarderPartie = new JButton("Sauvegarder");
    public static JButton boutonChoixCarte = new JButton("Valider");

    /* --------------------Spinner--------------------- */
    public static SpinnerModel spinnerModel = new SpinnerNumberModel(2, 2, 12, 1);
    public static JSpinner spinnerNbJoueur = new JSpinner(spinnerModel);

    /* --------------------TextArea--------------------- */
    public static JTextArea[] areaTabPseudo;

    /* --------------------Fonctionnalites/Taches--------------------- */
    public static JTextField fieldTache = new JTextField(screenHeight/15);
    public static DefaultListModel<String> listeTache = new DefaultListModel<>();
    public static JList<String> tachesList = new JList<>(listeTache);

    /* --------------------Label--------------------- */
    public static JLabel labelTitreAccueil = new JLabel("Planning Poker");
    public static JLabel labelTitreNbJoueur = new JLabel("Configuration de la partie");
    public static JLabel labelNbJoueur = new JLabel("<html>Nombre de joueur :<br>(entre 2 et 12)</html>");
    public static JLabel labelTitrePseudoJoueur = new JLabel("Choix des pseudos");
    public static JLabel labelTitreMode = new JLabel("Choix du mode de jeu");
    public static JLabel labelTitreFonctionnalite = new JLabel("Entrez vos fonctionnalites à voter");
    public static JLabel labelTitrePlateau = new JLabel("Jeu");
    public static JLabel labelPseudo;
    public static JLabel labelRegle;

    /* --------------------Checkbox--------------------- */
    public static JCheckBox checkUnanimate = new JCheckBox("Unanimité");
    public static JCheckBox checkMoyenne = new JCheckBox("Moyenne");

    /* --------------------Images--------------------- */
    public static String[] valeursCartes = {"0", "1", "2", "3", "5", "8", "13", "20", "40", "100", "cafe", "interro"};
    public static String[] nomFichiers = {"carte_0.jpg",
            "carte_1.jpg",
            "carte_2.jpg",
            "carte_3.jpg",
            "carte_5.jpg",
            "carte_8.jpg",
            "carte_13.jpg",
            "carte_20.jpg",
            "carte_40.jpg",
            "carte_100.jpg",
            "carte_cafe.jpg",
            "carte_interro.jpg"
    };

    public static BufferedImage[] carte = new BufferedImage[12];

    public static JLabel[] labelsCartes;
}
