import javax.swing.JTextArea;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Joueur {
    public static List<Joueur> listeJoueurs = new ArrayList<>();
    private final int id;
    private final String pseudo;
    public String voteCourant;

    public Joueur(int identifiant, String p) {
        this.pseudo = p;
        this.id = identifiant;
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
                return false;
            }
        }
        return true;
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

    public static void afficheListeJoueur() {
        System.out.println("Liste des Joueurs : ");
        for (Joueur joueur : listeJoueurs) {
            System.out.println("ID: " + joueur.getId() + ", Pseudo: " + joueur.getPseudo() + " vote : " + joueur.getVoteCourant());
        }
    }

    public static void ajouterVoteAuJoueur(String carte) {
        if (AffichageInfo.joueurVote == 0) {
            AffichageInfo.cartesVotees.clear();
        }
        for (Joueur joueur : Joueur.listeJoueurs) {
            if (joueur.getId() == (AffichageInfo.joueurVote + 1)) {
                joueur.setVoteEnCours(carte);
                AffichageInfo.joueurVote += 1;
                AffichageInfo.cartesVotees.add(carte);
                break;
            }
        }
    }
}