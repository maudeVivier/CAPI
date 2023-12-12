import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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
    public static int nbJoueur = 2;

    /* --------------------Couleurs--------------------- */
    public static Color couleurFond = new Color(0, 0, 50);

    /* --------------------Differents boutons--------------------- */
    public static JButton boutonNouvellePartie = new JButton("Nouvelle Partie");
    public static JButton boutonReprendrePartie = new JButton("Reprendre la partie");
    public static JButton boutonValiderNbJoueur = new JButton("Valider");
    public static JButton boutonValiderPseudo = new JButton("Valider");
    public static JButton boutonValiderMode = new JButton("Valider");
    public static JButton boutonSauvegarderPartie = new JButton("Sauvegarder");
    public static JButton boutonChoixCarte = new JButton("Valider");

    /* --------------------Spinner--------------------- */
    public static SpinnerModel spinnerModel = new SpinnerNumberModel(2, 2, 12, 1);
    public static JSpinner spinnerNbJoueur = new JSpinner(spinnerModel);

    /* --------------------TextArea--------------------- */
    public static JTextArea[] areaTabPseudo;

    /* --------------------Label--------------------- */
    public static JLabel labelTitreAccueil = new JLabel("Planning Poker");
    public static JLabel labelTitreNbJoueur = new JLabel("Configuration de la partie");
    public static JLabel labelNbJoueur = new JLabel("<html>Nombre de joueur :<br>(entre 2 et 12)</html>");
    public static JLabel labelTitrePseudoJoueur = new JLabel("Choix des pseudos");
    public static JLabel labelTitreMode = new JLabel("Choix du mode de jeu");
    public static JLabel labelTitrePlateau = new JLabel("Jeu");

    /* --------------------Checkbox--------------------- */
    public static JCheckBox checkUnanimate = new JCheckBox("Unanimité");
    public static JCheckBox checkMoyenne = new JCheckBox("Moyenne");

    /* --------------------Images--------------------- */
    public static BufferedImage carte_0;
    public static BufferedImage carte_1;
    public static BufferedImage carte_2;
    public static BufferedImage carte_3;
    public static BufferedImage carte_5;
    public static BufferedImage carte_8;
    public static BufferedImage carte_13;
    public static BufferedImage carte_20;
    public static BufferedImage carte_40;
    public static BufferedImage carte_100;
    public static BufferedImage carte_cafe;
    public static BufferedImage carte_interro;

    public static JLabel labelCarte0;
    public static JLabel labelCarte1;
    public static JLabel labelCarte2;
    public static JLabel labelCarte3;
    public static JLabel labelCarte5;
    public static JLabel labelCarte8;
    public static JLabel labelCarte13;
    public static JLabel labelCarte20;
    public static JLabel labelCarte40;
    public static JLabel labelCarte100;
    public static JLabel labelCarteCafe;
    public static JLabel labelCarteInterro;
}
