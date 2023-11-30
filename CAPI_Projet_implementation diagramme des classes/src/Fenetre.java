import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame{
    public static void main(String[] args) {
        /*Créer une nouvelle fenêtre*/
        JFrame frame = new JFrame("Planning Poker");
        AffichageConfiguration affichage;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        affichage = new AffichageConfiguration();
        affichage.setFocusable(true);

        frame.getContentPane().add(affichage, BorderLayout.CENTER);

        frame.setPreferredSize(new Dimension(AffichageInfo.screenWidth, AffichageInfo.screenHeight));
        frame.pack();

        frame.setVisible(true);
        frame.getContentPane().add(affichage);

    }
}