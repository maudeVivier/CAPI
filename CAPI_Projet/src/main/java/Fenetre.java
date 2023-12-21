/**
 * @file Fenetre.java
 * @brief Définition de la classe Fenetre pour la création de la fenêtre principale.
 */

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @class Fenetre
 * @brief Classe principale pour la création de la fenêtre de l'application Planning Poker.
 */
public class Fenetre extends JFrame{
    /** Instance de la fenêtre principale. */
    public static JFrame frame = new JFrame("Planning Poker");

    /**
     * @brief Point d'entrée principal de l'application.
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            AffichageConfiguration affichageConfig = new AffichageConfiguration();
            frame.getContentPane().add(affichageConfig);

            affichageConfig.setMenu(AffichageInfo.MENU_ACCUEIL);

            frame.setSize(AffichageInfo.screenWidth, AffichageInfo.screenHeight);
            frame.setVisible(true);
            frame.pack();
        });
    }
}

