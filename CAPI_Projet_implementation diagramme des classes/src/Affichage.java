import java.awt.*;
import javax.swing.JSpinner;

//Classe qui va permettre de creer les differentes fonction d'affichage du panel
public class Affichage {
    public static void PageAccueil(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Calibri", Font.PLAIN, AffichageInfo.sizeTitre)); //chnager la police si ca plait pas
        g.drawString("Planning Poker", AffichageInfo.screenWidth / 3, AffichageInfo.screenHeight / 6);

        AffichageInfo.boutonNouvellePartie.setFont(new Font("Calibri", Font.BOLD, AffichageInfo.sizeTexte));
        AffichageInfo.boutonNouvellePartie.setBackground(Color.darkGray);
        AffichageInfo.boutonNouvellePartie.setForeground(Color.white);
        AffichageInfo.boutonNouvellePartie.setBounds((AffichageInfo.screenWidth / 3) + (AffichageInfo.screenWidth / 12), (AffichageInfo.screenHeight / 3), AffichageInfo.largeurBouton, AffichageInfo.hauteurBouton);
    }

    public static void MenuConfigPartie(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Calibri", Font.PLAIN, AffichageInfo.sizeTitre)); //chnager la police si ca plait pas
        g.drawString("Choisis le nombre de joueur", AffichageInfo.screenWidth/5, AffichageInfo.screenHeight/6);


        g.setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));

        g.drawString("Texte :", (AffichageInfo.screenWidth/4)+(AffichageInfo.screenWidth/30), (AffichageInfo.screenHeight/4)+(AffichageInfo.screenHeight/13));
        g.drawString("encore du texte", (AffichageInfo.screenWidth/5)+(AffichageInfo.screenWidth/34), (AffichageInfo.screenHeight/3)+(AffichageInfo.screenHeight/46));

        /*
        // Pour le texteArea
        AffichageInfo.nb_joueur.setFont(new Font("Arial", Font.BOLD, AffichageInfo.sizeTexte));
        AffichageInfo.nb_joueur.setBounds
         */

        AffichageInfo.nb_joueur_Spinner.setBorder(null);
        AffichageInfo.nb_joueur_Spinner.setOpaque(false);

        AffichageInfo.nb_joueur_Spinner.setBounds((AffichageInfo.screenWidth/3)+(AffichageInfo.screenWidth/10), (AffichageInfo.screenHeight/4)+(AffichageInfo.screenHeight/18), AffichageInfo.largeurReponse, AffichageInfo.hauteurReponse);
        //AffichageInfo.nb_joueur_Spinner.setBounds((AffichageInfo.screenWidth/3)+(AffichageInfo.screenWidth/10), (AffichageInfo.screenHeight/4)+(AffichageInfo.screenHeight/18), AffichageInfo.largeurReponse*2, AffichageInfo.hauteurReponse);
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) AffichageInfo.nb_joueur_Spinner.getEditor();
        editor.getTextField().setFont(new Font("Arial", Font.PLAIN, AffichageInfo.sizeTexte));
        AffichageInfo.nb_joueur_Spinner.setEnabled(true);
    }
}
