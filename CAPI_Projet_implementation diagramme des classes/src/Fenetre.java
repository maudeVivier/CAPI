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

    /*
    public static void main(String[] args) {
        Créer une nouvelle fenêtre
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

    }*/
}