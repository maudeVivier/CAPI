import java.util.*;
public class PlanningPoker {
    private List<Joueur> monJoueurs;
    private ModeDeJeu moRegle;
    private Backlog monBacklog;

    public PlanningPoker(List<Joueur> unListeJoueur, ModeDeJeu unRegle) //, Backlog unBacklog)
    {
        monJoueurs = unListeJoueur;
        moRegle = unRegle;
        //monBacklog = unBacklog;
    }
    public void initialiserPartie() { //Maude : a supprimer
        // Logique d'initialisation
    }

    public void validerBacklog() {
        // Logique de validation du backlog
    }

    public void enregistrerResultats() {
        // Logique d'enregistrement des résultats
    }

    public void chargerPartie() {
        // Logique de chargement d'une partie
    }
}