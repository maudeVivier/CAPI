/**
 * @file Joueur.java
 * @brief Définition de la classe Joueur.
 */

import javax.swing.JTextArea;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * @class Joueur
 * @brief Représente un joueur dans le jeu.
 */
public class Joueur {
    /**
     * Liste statique contenant tous les joueurs.
     */
    public static List<Joueur> listeJoueurs = new ArrayList<>();

    /**
     * Identifiant unique du joueur.
     */
    private final int id;

    /**
     * Pseudo du joueur.
     */
    private final String pseudo;

    /**
     * Vote courant du joueur.
     */
    public String voteCourant;


    /**
     * Constructeur de la classe Joueur.
     *
     * @param identifiant Identifiant unique du joueur.
     * @param p Pseudo du joueur.
     */
    public Joueur(int identifiant, String p) {
        this.pseudo = p;
        this.id = identifiant;
        this.voteCourant = null;
    }

    /**
     * Getter pour l'identifiant du joueur.
     *
     * @return Identifiant du joueur.
     */
    public int getId() {
        return id;
    }


    /**
     * Getter pour le pseudo du joueur.
     *
     * @return Pseudo du joueur.
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Getter pour le vote courant du joueur.
     *
     * @return Vote courant du joueur.
     */
    public String getVoteCourant() {
        return voteCourant;
    }

    /**
     * Setter pour le vote en cours du joueur.
     *
     * @param nouveauVote Nouveau vote du joueur.
     */
    public void setVoteEnCours(String nouveauVote) {
        this.voteCourant = nouveauVote;
    }

    /**
     * Fonction pour vérifier si tous les pseudos sont différents.
     *
     * @return true si tous les pseudos sont uniques, sinon false.
     */    public static boolean verifierPseudosUniques() {
        Set<String> pseudosSet = new HashSet<>();

        for (JTextArea pseudoTextArea : AffichageInfo.areaTabPseudo) {
            String pseudo = pseudoTextArea.getText().trim();
            if (!pseudosSet.add(pseudo)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Fonction pour vérifier si tous les pseudos ne sont pas nuls.
     *
     * @return true si aucun pseudo n'est nul, sinon false.
     */
    public static boolean verifierPseudosNonNuls() {
        for (JTextArea pseudoTextArea : AffichageInfo.areaTabPseudo) {
            if (pseudoTextArea.getText().trim().isEmpty()) {
                return false; // Au moins un JTextArea est nul
            }
        }
        return true; // Tous les JTextArea sont non nuls
    }

    /**
     * Crée une liste de joueurs à partir des pseudos.
     *
     * @return Liste des joueurs créés.
     */
    public static List<Joueur> creerListeDeJoueurs() {
        List<Joueur> listeJoueurs = new ArrayList<>();
        int i = 1;
        for (JTextArea pseudoTextArea : AffichageInfo.areaTabPseudo) {
            listeJoueurs.add(new Joueur(i, pseudoTextArea.getText()));
            i++;
        }
        return listeJoueurs;
    }

    /**
     * Ajoute un vote au joueur spécifié.
     *
     * @param carte Carte à voter.
     */
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