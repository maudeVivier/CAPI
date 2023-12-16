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

    /*Fonction pour verifier si tous les pseudos sont differents*/
    public static boolean verifierPseudosUniques() {
        Set<String> pseudosSet = new HashSet<>();

        for (JTextArea pseudoTextArea : AffichageInfo.areaTabPseudo) {
            String pseudo = pseudoTextArea.getText().trim();
            if (!pseudosSet.add(pseudo)) {
                return false; // Pseudo déjà rencontré, n'est pas unique
            }
        }
        return true; // Tous les pseudos sont uniques
    }

    public static boolean verifierPseudosNonNuls() {
        for (JTextArea pseudoTextArea : AffichageInfo.areaTabPseudo) {
            if (pseudoTextArea.getText().trim().isEmpty()) {
                return false; // Au moins un JTextArea est nul
            }
        }
        return true; // Tous les JTextArea sont non nuls
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

    public static void ajouterVoteAuJoueur(String carte) {
        if (AffichageInfo.joueurVote == 0) {
            AffichageInfo.cartesVotees.clear();
        }
        for (Joueur joueur : Joueur.listeJoueurs) {
            if (joueur.getId() == (AffichageInfo.joueurVote + 1)) {
                System.out.println("Joueur " + (AffichageInfo.joueurVote + 1) + " ajoute la carte " + carte);
                joueur.setVoteEnCours(carte);
                AffichageInfo.joueurVote += 1;
                AffichageInfo.cartesVotees.add(carte);
                break;
            }
        }
    }

    public void voter(String carte) {
        // Logique de vote
    }
}