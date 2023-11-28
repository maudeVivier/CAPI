import java.awt.*;

//Classe qui va permettre de creer les differentes fonction d'affichage du panel
public class Affichage {
    public static void PageAccueil(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Calibri", Font.PLAIN, Info.sizeTitre)); //chnager la police si ca plait pas
        g.drawString("Planning Poker", Info.screenWidth / 3, Info.screenHeight / 6);

        Info.boutonConfig.setFont(new Font("Calibri", Font.BOLD, Info.sizeTexte));
        Info.boutonConfig.setBackground(Color.darkGray);
        Info.boutonConfig.setForeground(Color.white);
        Info.boutonConfig.setBounds((Info.screenWidth / 3) + (Info.screenWidth / 12), (Info.screenHeight / 3), Info.largeurBouton, Info.hauteurBouton);
    }

    public static void MenuConfigPartie(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Calibri", Font.PLAIN, Info.sizeTitre)); //chnager la police si ca plait pas
        g.drawString("Choix des perso", Info.screenWidth/3, Info.screenHeight/6);


        g.setFont(new Font("Arial", Font.PLAIN, Info.sizeTexte));

        g.drawString("Texte :", (Info.screenWidth/4)+(Info.screenWidth/30), (Info.screenHeight/4)+(Info.screenHeight/13));
        g.drawString("encore du texte", (Info.screenWidth/5)+(Info.screenWidth/34), (Info.screenHeight/3)+(Info.screenHeight/46));


        Info.nb_joueur.setFont(new Font("Arial", Font.BOLD, Info.sizeTexte));
        Info.nb_joueur.setBounds((Info.screenWidth/3)+(Info.screenWidth/10), (Info.screenHeight/4)+(Info.screenHeight/18), Info.largeurReponse, Info.hauteurReponse);

    }
}
