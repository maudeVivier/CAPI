import javax.swing.*;
import java.util.*;

public class Joueur {
    public static List<Joueur> listeJoueurs;
    private final int monId;
    private final String monPseudo;
    private ArrayList<String> maListeCarte;
    public String monVoteCourant;

    public Joueur(int unId, String unPseudo) {
        monPseudo = unPseudo;
        monId = unId;
        maListeCarte = null;
        monVoteCourant = null;
    }

    public int getMonId() {
        return monId;
    }

    public String getMonPseudo() {
        return monPseudo;
    }

    public String getMonVoteCourant() {
        return monVoteCourant;
    }

    public void setVoteEnCours(String nouveauVote) {
        monVoteCourant = nouveauVote;
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
            System.out.println("ID: " + joueur.getMonId() + ", Pseudo: " + joueur.getMonPseudo());
        }
    }
    public void voter(String carte) {
        // Logique de vote
    }
}