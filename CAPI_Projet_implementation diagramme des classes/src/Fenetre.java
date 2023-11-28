import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame{
    public static void main(String[] args) {
        /*Créer une nouvelle fenêtre*/
        JFrame frame = new JFrame("Planning Poker");
        Backlog backlog;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backlog = new Backlog(Info.screenWidth, Info.screenHeight, frame);
        backlog.setFocusable(true);

        frame.getContentPane().add(backlog, BorderLayout.CENTER);

        frame.setPreferredSize(new Dimension(Info.screenWidth, Info.screenHeight));
        frame.pack();

        frame.setVisible(true);
        frame.getContentPane().add(backlog);

    }
}