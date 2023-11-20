import Vue.Fenetre;
import Vue.Joueur;
import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
/*
* @brief la classe Affichage contient les diffferents paramètres de Jeux
*
* */
public class Affichage {
    public static JLabel label = new JLabel("Nombre de joueur : " , SwingConstants.CENTER);
    public static JLabel label2 = new JLabel("Inserer pseudo " , SwingConstants.CENTER);
    public static Font fontLabel =  new Font("Arial", Font.BOLD, (int)(Fenetre.screenWidth * 0.010));
    public static int fontSize;
    public static int sizeTitre = (int)(Fenetre.screenWidth * 0.089);
    public static int sizeTexte = (int)(Fenetre.screenWidth * 0.015);

    public static int nombre_joueur;
    List<Joueur> liste_joueur = new ArrayList<Joueur>();


    public static void PageAccueil(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, sizeTitre));
        g.drawString("Menu", (Fenetre.screenWidth/5), (Fenetre.screenHeight/6));
        g.setColor(Color.WHITE);
    }
}
