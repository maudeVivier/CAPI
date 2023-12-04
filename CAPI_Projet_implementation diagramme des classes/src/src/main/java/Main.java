public class Main {
    public static void main(String[] args) {
        //__On récupèrera le nombre de joueur___
        int nombre_joueur = 3;
        //Création des joueurs
        for (int i =0 ; i<nombre_joueur ; i++)
        {
            //__On récupèrera les pseudos___
            Joueur gamer= new Joueur(i,"Joueur"+i);
        }
    }
}