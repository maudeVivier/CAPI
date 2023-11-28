package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;


public class Fenetre extends JFrame{
    private JPanel Panel1;
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int screenWidth = (int) screenSize.getWidth();
    public static final int screenHeight = (int) screenSize.getHeight();

    public Fenetre()
    {
        Panel1.setBackground(Color.GRAY);
        add(Panel1);
        setTitle("Planning Poker");
        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
/*
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(0,0,50));
         setLayout(null);
         Affichage.PageAccueil(g);
    }
*/
    public static void main(String[] args) {
        Fenetre t = new Fenetre();
        t.setVisible(true);
    }
}
