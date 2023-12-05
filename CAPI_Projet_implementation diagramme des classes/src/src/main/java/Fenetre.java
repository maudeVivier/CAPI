package src.main.java;

import javax.swing.*;

public class Fenetre extends JFrame{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Créez et affichez votre interface graphique ici
            JFrame frame = new JFrame("Planning Poker");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            AffichageConfiguration affichageConfig = new AffichageConfiguration();
            frame.getContentPane().add(affichageConfig);

            affichageConfig.setMenu(0);

            frame.setSize(AffichageInfo.screenWidth, AffichageInfo.screenHeight);
            frame.setVisible(true);
            frame.pack();
        });
    }
}