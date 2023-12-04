package src.main.java;

import java.awt.*;
import javax.swing.*;

//Classe qui va permettre de creer les differentes fonction d'affichage du panel
public class Affichage {
    public static void PageAccueil(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Calibri", Font.PLAIN, AffichageInfo.sizeTitre));
        g.drawString("Planning Poker", AffichageInfo.screenWidth / 3, AffichageInfo.screenHeight / 6);

        AffichageInfo.boutonNouvellePartie.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
        AffichageInfo.boutonNouvellePartie.setBackground(Color.darkGray);
        AffichageInfo.boutonNouvellePartie.setForeground(Color.white);
        AffichageInfo.boutonNouvellePartie.setBounds((AffichageInfo.screenWidth / 3) + (AffichageInfo.screenWidth / 12), (AffichageInfo.screenHeight / 3), AffichageInfo.largeurBouton, AffichageInfo.hauteurBouton);
    }

    public static void MenuConfigPartie(Graphics g){
        if(AffichageInfo.menu==1) { //Partie pour choisir le nombre de joueurs
            g.setColor(Color.white);
            g.setFont(new Font("Calibri", Font.PLAIN, AffichageInfo.sizeTitre));
            g.drawString("Choisis le nombre de joueur", AffichageInfo.screenWidth/5, AffichageInfo.screenHeight/6);

            g.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
            g.drawString("Nombre de joueurs :", (AffichageInfo.screenWidth / 4) + (AffichageInfo.screenWidth / 30), (AffichageInfo.screenHeight / 4) + (AffichageInfo.screenHeight / 13));
            g.drawString("(entre 2 et 12)", (AffichageInfo.screenWidth / 4) + (AffichageInfo.screenWidth / 20), (AffichageInfo.screenHeight / 3) + (AffichageInfo.screenHeight / 46));

            AffichageInfo.nb_joueur_Spinner.setBorder(null);
            AffichageInfo.nb_joueur_Spinner.setOpaque(false);

            AffichageInfo.nb_joueur_Spinner.setBounds((AffichageInfo.screenWidth / 3) + (AffichageInfo.screenWidth / 10), (AffichageInfo.screenHeight / 4) + (AffichageInfo.screenHeight / 18), AffichageInfo.largeurReponse, AffichageInfo.hauteurReponse);
            JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) AffichageInfo.nb_joueur_Spinner.getEditor();
            editor.getTextField().setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
            AffichageInfo.nb_joueur_Spinner.setEnabled(true);

            AffichageInfo.boutonValiderNbJoueur.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
            AffichageInfo.boutonValiderNbJoueur.setBackground(Color.darkGray);
            AffichageInfo.boutonValiderNbJoueur.setForeground(Color.white);
            AffichageInfo.boutonValiderNbJoueur.setBounds((AffichageInfo.screenWidth / 4) + (AffichageInfo.screenWidth / 4), (AffichageInfo.screenHeight / 4) + (AffichageInfo.screenHeight / 20), AffichageInfo.largeurBouton / 2, AffichageInfo.hauteurBouton / 2);
        }
        else if(AffichageInfo.menu==2){ //Recuperer les pseudos de tous les joueurs
            g.setColor(Color.white);
            g.setFont(new Font("Calibri", Font.PLAIN, AffichageInfo.sizeTitre));
            g.drawString("Choix des pseudos", AffichageInfo.screenWidth/4, AffichageInfo.screenHeight/6);

            int x0 = (AffichageInfo.screenWidth/10);
            int y0 = (AffichageInfo.screenHeight/4) + (AffichageInfo.screenHeight/25);
            int valDecY = AffichageInfo.screenHeight/9;
            int valDecX = AffichageInfo.screenWidth/5 + AffichageInfo.screenWidth/23;

            /*Affichage de texte pseudo : */
            g.setFont(new Font("Calibri", Font.PLAIN, AffichageInfo.sizeTexte));
            for (int i = 0, decx = 0, decy = 0; i < AffichageInfo.nbJoueur; i++, decy+= valDecY) {
                if(i<=5){
                    g.drawString("Pseudo " + (i + 1) + " : ", x0, y0 + decy);
                }
                else{
                    if(i==6){
                        decx += AffichageInfo.largeurReponse + valDecX;
                        decy = 0;
                    }
                    g.drawString("Pseudo "+ (i+1) + " : ", x0 + decx, y0 + decy);
                }
            }
            AffichageInfo.boutonValiderPseudo.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
            AffichageInfo.boutonValiderPseudo.setBackground(Color.darkGray);
            AffichageInfo.boutonValiderPseudo.setForeground(Color.white);
            AffichageInfo.boutonValiderPseudo.setBounds((AffichageInfo.screenWidth / 3) + (AffichageInfo.screenWidth / 2)  + (AffichageInfo.screenWidth / 30), (AffichageInfo.screenHeight / 3) + (AffichageInfo.screenHeight / 2), AffichageInfo.largeurBouton / 2, AffichageInfo.hauteurBouton / 2);

        }
    }
}
