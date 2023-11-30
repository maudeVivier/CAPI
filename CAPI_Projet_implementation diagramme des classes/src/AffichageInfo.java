import javax.swing.*;
import java.awt.*;

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
    public static int largeurReponse = screenWidth / 5;
    public static int hauteurReponse = screenHeight / 18;

    /* --------------------Differents boutons--------------------- */
    public static JButton boutonNouvellePartie = new JButton("Nouvelle Partie");

    public static JButton boutonValiderNbJoueur = new JButton("Valider");

    public static JButton boutonValiderPseudo = new JButton("Valider");

    public static JTextArea[] areaTabPseudo ;

    /* --------------------Spinner--------------------- */
    public static SpinnerModel spinnerModel = new SpinnerNumberModel(2, 2, 12, 1);

    // Créer un JSpinner avec le SpinnerModel
    public static JSpinner nb_joueur_Spinner = new JSpinner(spinnerModel);

    /* --------------------Différentes variables--------------------- */
    public static int nbJoueur = 2;

    /* --------------------Variable menu qui varie--------------------- */
    public static int menu = 0;
    //public static JTextArea nb_joueur =  new JTextArea();
}
