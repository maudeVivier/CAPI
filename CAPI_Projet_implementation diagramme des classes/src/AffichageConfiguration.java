import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.JSpinner;


public class AffichageConfiguration extends JPanel {

    /*Fonction ou on va mettre des actions avec des touches claviers,
    toucher un bouton, ect
    */
    public AffichageConfiguration(int screenWidth, int screenHeight, JFrame frame){
        this.setLayout(null);

        /* -------------------Bouton pour choisir le nombre de joueur ainsi que les pseudos---------------------- */
        AffichageInfo.boutonNouvellePartie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AffichageInfo.menu=1;
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

        if (AffichageInfo.menu == 0) { //accueil
            add(AffichageInfo.boutonNouvellePartie);
            /*SpinnerModel spinnerModel = new SpinnerNumberModel(2, 2, 100, 1);

            // Créer un JSpinner avec le SpinnerModel
            JSpinner nbJoueurSpinner = new JSpinner(spinnerModel);
            nbJoueurSpinner.setBounds((AffichageInfo.screenWidth/3)+(AffichageInfo.screenWidth/10), (AffichageInfo.screenHeight/4)+(AffichageInfo.screenHeight/18), AffichageInfo.largeurReponse, AffichageInfo.hauteurReponse);

            add(nbJoueurSpinner, BorderLayout.CENTER);
            */
            Affichage.PageAccueil(g);
        }

        if(AffichageInfo.menu == 1){ //menu choisi nombre de joueur et pseudo
            remove(AffichageInfo.boutonNouvellePartie);
            add(AffichageInfo.nb_joueur_Spinner);
            Affichage.MenuConfigPartie(g);
            setFocusable(true);
        }

    }
}