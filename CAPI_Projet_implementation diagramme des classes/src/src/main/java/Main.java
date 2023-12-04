package src.main.java;

public class Main {
    public static void main(String[] args) {
        int nombre_joueur = 3;
        //Création des joueurs
        for (int i =0 ; i<nombre_joueur ; i++)
        {
            Joueur gamer= new Joueur(i,"Joueur"+i);
        }
    }
}