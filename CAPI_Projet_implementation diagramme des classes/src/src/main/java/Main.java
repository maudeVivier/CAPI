package src.main.java;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //__On récupèrera le nombre de joueur___

        int un_nombre_joueur = AffichageInfo.nbJoueur;

        //Création d'un tableau de Joueur, des joueurs
        ArrayList<Joueur> unTabJoueurs = new ArrayList();;
        for (int i =0 ; i<un_nombre_joueur ; i++)
        {
            //__On récupèrera les pseudos___
            Joueur un_joueur= new Joueur(i,"Joueur"+i);
            unTabJoueurs.add(un_joueur);
        }
        //__On récupèrera le mode de jeu__
        ReglesPlanningPoker unRegle = new ReglesPlanningPoker(ModeDeJeu.MOYENNE);



    }
}