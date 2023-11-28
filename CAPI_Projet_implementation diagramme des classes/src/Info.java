import javax.swing.*;
import java.awt.*;

public class Info {
    /* --------------------Dimension de l'écran--------------------- */
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int screenWidth = (int) screenSize.getWidth();
    public static final int screenHeight = (int) screenSize.getHeight();
    //variable menu va varier en fonction d'ou on est


    /* --------------------Differentes tailles de police--------------------- */
    public static int sizeTitre = (int) (screenWidth * 0.059);
    public static int sizeTexte = (int) (screenWidth * 0.015);

    /* --------------------Differentes tailles pour les boutons--------------------- */
    public static int largeurBouton = screenWidth / 5;
    public static int hauteurBouton = (screenHeight / 10) - (screenHeight / 138);
    public static int largeurReponse = screenWidth / 5;
    public static int hauteurReponse = screenHeight / 18;

    /* --------------------Different boutons--------------------- */
    public static JButton boutonConfig = new JButton("Configuration");

    public static JTextArea nb_joueur =  new JTextArea();


    /* --------------------Variable menu qui varie--------------------- */
    public static int menu = 0;
}
