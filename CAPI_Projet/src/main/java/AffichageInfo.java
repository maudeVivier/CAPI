import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * @class AffichageInfo
 * @brief Classe statique contenant les informations d'affichage pour l'interface graphique.

 * Cette classe stocke des paramètres tels que la dimension de l'écran, les tailles de police,
 * les variables, des couleurs, des boutons, des spinners, des textareas,
 * des labels, et des checkboxes utilisés dans l'interface graphique du jeu "Planning Poker".
 */

public class AffichageInfo {
    static PlanningPoker planningPoker;
    /* --------------------Dimension de l'écran--------------------- */
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int screenWidth = (int) screenSize.getWidth();
    public static final int screenHeight = (int) screenSize.getHeight();

    /* --------------------Differentes tailles de police--------------------- */
    public static int sizeTitre = (int) (screenWidth * 0.059);
    public static int sizeTexte = (int) (screenWidth * 0.015);

    /* --------------------Différentes variables--------------------- */
    // Obtenez le répertoire de travail actuel
    public static String workingDirectory = System.getProperty("user.dir");

    //nombre de joueurs qui participent à la partie
    public static int nbJoueur;

    //nombre de tour réalisé pour voter une regle
    public static int tour = 1;

    //pour savoir quel joueur est en train de voter
    public static int joueurVote = 0;

    //nombre de fonctionnalites à voter
    public static int nbFonctionnalite;

    //pour savoir quelle fonctionnalite est en train de voter
    public static int fonctionnaliteVote = 0;

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


    /* --------------------Elements differents pour le menu accueil--------------------- */
    public static JLabel labelTitreAccueil = new JLabel("Planning Poker");
    public static JButton boutonNouvellePartie = new JButton("Nouvelle Partie");
    public static JButton boutonReprendrePartie = new JButton("Reprendre la partie");


    /* --------------------Elements differents pour le menu choix du nombre de joueurs--------------------- */
    public static JLabel labelTitrePseudoJoueur = new JLabel("Choix des pseudos");
    public static JLabel labelTitreNbJoueur = new JLabel("Configuration de la partie");
    public static JLabel labelNbJoueur = new JLabel("<html><center>Nombre de joueur :<br>(entre 2 et 12)</center></html>");
    public static JButton boutonValiderNbJoueur = new JButton("Valider");
    /* --------------------Spinner--------------------- */
    public static SpinnerModel spinnerModel = new SpinnerNumberModel(2, 2, 12, 1);
    public static JSpinner spinnerNbJoueur = new JSpinner(spinnerModel);


    /* --------------------Elements differents pour le menu choix des pseudos des joueurs--------------------- */
    public static JButton boutonValiderPseudo = new JButton("Valider");
    public static JTextArea[] areaTabPseudo;


    /* --------------------Elements differents pour le menu choix du mode--------------------- */
    public static JLabel labelTitreMode = new JLabel("Choix du mode de jeu");
    public static JButton boutonValiderMode = new JButton("Valider");

    /* --------------------Checkbox--------------------- */
    public static JCheckBox checkUnanimate = new JCheckBox("Unanimité");
    public static JCheckBox checkMoyenne = new JCheckBox("Moyenne");


    /* --------------------Elements differents pour le menu ecriture des fonctionnalités--------------------- */
    public static JLabel labelTitreFonctionnalite = new JLabel("Entrez vos fonctionnalités à voter");
    public static JButton boutonValiderFonctionnalite = new JButton("Valider");
    public static JButton boutonPasserPlateau = new JButton("Commencer à voter");

    /* --------------------Fonctionnalites--------------------- */
    public static JTextField fieldFonctionnalite = new JTextField(screenHeight/15);
    public static DefaultListModel<String> listeFonctionnalite = new DefaultListModel<>();
    public static JList<String> fonctionnalitesList = new JList<>(listeFonctionnalite);


    /* --------------------Elements differents pour le menu plateau--------------------- */
    public static JLabel labelTitrePlateau = new JLabel("Jeu");
    public static JLabel labelPseudo;
    public static JLabel labelRegle;
    public static JLabel labelModeEtTour;
    public static JLabel labelTimer;
    public static JButton boutonChoixCarte = new JButton("Valider");

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
