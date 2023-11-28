import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class Backlog extends JPanel {
    private ArrayList<Fonctionnalite> monFonctionnalites;

    /*Fonction ou on va mettre des actions avec des touches claviers,
    toucher un bouton, ect
    */
    public Backlog(int screenWidth, int screenHeight, JFrame frame){
        this.setLayout(null);

        /* -------------------Bouton pour choisir le nombre de joueur ainsi que les pseudos---------------------- */
        Info.boutonConfig.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Info.menu=1;
                repaint();
            }
        });

    }

    /*
    Fonction pour modifier l'apparence de la fenetre
    enlever bouton, rajouter bouton, ect
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(0, 0, 50));

        if (Info.menu == 0) { //accueil
            add(Info.boutonConfig);
            Affichage.PageAccueil(g);
        }

        if(Info.menu == 1){ //menu choisi nombre de joueur et pseudo
            remove(Info.boutonConfig);
            add(Info.nb_joueur);
            Affichage.MenuConfigPartie(g);
        }

    }

    public void ajouterFonctionnalite(Fonctionnalite fonctionnalite) {
        // Logique d'ajout de fonctionnalité au backlog
    }
}