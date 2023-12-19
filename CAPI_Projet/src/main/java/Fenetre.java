import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame{
    public static JFrame frame = new JFrame("Planning Poker");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Créez et affichez votre interface graphique ici
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            AffichageConfiguration affichageConfig = new AffichageConfiguration();
            frame.getContentPane().add(affichageConfig);

            affichageConfig.setMenu(AffichageInfo.MENU_ACCUEIL, false);

            frame.setSize(AffichageInfo.screenWidth, AffichageInfo.screenHeight);
            frame.setVisible(true);
            frame.pack();
        });
    }
}

