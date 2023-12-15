import java.util.*;
public class PlanningPoker {
    private List<Joueur> joueurs;
    private ModeDeJeu regle;
    private Backlog backlog;

    public PlanningPoker(List<Joueur> listeJoueur, ModeDeJeu regle) //, Backlog backlog)
    {
        this.joueurs = listeJoueur;
        this.regle = regle;
        //this.backlog = backlog;
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