/**
 * @file PlanningPoker.java
 * @brief Définition de la classe PlanningPoker.
 */

import javax.swing.JOptionPane;

import java.io.IOException;

import java.util.List;

/**
 * @class PlanningPoker
 * @brief Gère une instance unique du jeu de planning poker.
 */
public class PlanningPoker {

    /** @var planningPoker l'instance unique de la classe PlanningPoker. */
    private static PlanningPoker planningPoker;
    /** @var listeFonctionnalites la liste des fonctionnalités à estimer au planning poker. */
    private static List<Fonctionnalite> listeFonctionnalites;

    /** @var listeJoueurs la liste des joueurs participant au planning poker. */
    private static List<Joueur> listeJoueurs;

    /** @var modeDeJeu le mode de jeu du planning poker. */
    private static ModeDeJeu modeDeJeu;


    /**
     * @brief Constructeur privé de la classe PlanningPoker.
     * @param listeFonctionnalite La liste des fonctionnalités.
     * @param listeJoueur La liste des joueurs.
     * @param regle Le mode de jeu.
     */
    private PlanningPoker(List<Fonctionnalite> listeFonctionnalite, List<Joueur> listeJoueur, ModeDeJeu regle) {
        listeFonctionnalites = listeFonctionnalite;
        listeJoueurs = listeJoueur;
        modeDeJeu = regle;
    }

    /**
     * @brief Obtient l'instance unique de la classe PlanningPoker.
     * @param listeFonctionnalites La liste des fonctionnalités.
     * @param listeJoueur La liste des joueurs.
     * @param regle Le mode de jeu.
     * @return L'instance unique de PlanningPoker.
     */
    public static synchronized PlanningPoker getInstance(List<Fonctionnalite> listeFonctionnalites, List<Joueur> listeJoueur, ModeDeJeu regle) {
        if (planningPoker == null) {
            planningPoker = new PlanningPoker(listeFonctionnalites, listeJoueur, regle);
        }
        return planningPoker;
    }

    /**
     * @brief Obtient la liste des fonctionnalités.
     * @return La liste des fonctionnalités du planning poker.
     */
    public static List<Fonctionnalite> getListeFonctionnalites() {
        return listeFonctionnalites;
    }

    /**
     * @brief Obtient la liste des joueurs.
     * @return La liste des joueurs participant au planning poker.
     */
    public static List<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    /**
     * @brief Obtient le mode de jeu actuel.
     * @return Le mode de jeu du planning poker.
     */
    public static ModeDeJeu getModeDeJeu() {
        return modeDeJeu;
    }

    /**
     * @brief Méthode appelée lorsque la partie est terminée.
     */
    public static void partieFinie() {
        Backlog.sauvegarderEnJSON();
        JOptionPane.showMessageDialog(null, "<html>Toutes les fonctionnalités ont été traitées" +
                        "<br><br>" +
                        "Elles sont sauvegardées dans un fichier JSON</html>" +
                        "<br><br>"
                , "Information", JOptionPane.INFORMATION_MESSAGE);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Fermeture de la fenêtre
        Fenetre.frame.dispose();
    }

    /**
     * @brief Charge une partie sauvegardée.
     * @throws IOException En cas d'erreur lors de la lecture depuis le fichier JSON.
     */
    public static void chargerPartie() throws IOException {
        Backlog.chargerDepuisJSON();
        planningPoker = getInstance(Fonctionnalite.listeFonctionnalites, Joueur.listeJoueurs, ReglesPlanningPoker.modeDeJeu);
    }
}

