import javax.swing.*;
import java.util.*;

public class Joueur {
    public static List<Joueur> listeJoueurs;
    private final int id;
    private final String pseudo;
    private ArrayList<String> listeCarte;
    public String voteCourant;

    public Joueur(int identifiant, String p) {
        this.pseudo = p;
        this.id = identifiant;
        this.listeCarte = null;
        this.voteCourant = null;
    }

    public int getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getVoteCourant() {
        return voteCourant;
    }

    public void setVoteEnCours(String nouveauVote) {
        this.voteCourant = nouveauVote;
    }

    public static List<Joueur> creerListeDeJoueurs() {
        List<Joueur> listeJoueurs = new ArrayList<>();
        int i = 1;
        for (JTextArea pseudoTextArea : AffichageInfo.areaTabPseudo) {
            listeJoueurs.add(new Joueur(i, pseudoTextArea.getText()));
            i++;
        }
        return listeJoueurs;
    }

    public static void afficheListeJoueur(List<Joueur> listeJoueurs){
        // Parcourir et afficher la liste des joueurs
        for (Joueur joueur : listeJoueurs) {
            System.out.println("ID: " + joueur.getId() + ", Pseudo: " + joueur.getPseudo());
        }
    }
    public void voter(String carte) {
        // Logique de vote
    }
}