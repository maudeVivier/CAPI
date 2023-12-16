import java.util.*;
public class PlanningPoker {
    public static PlanningPoker planningPoker;
    public List<Joueur> listeJoueurs;
    private ModeDeJeu modeDeJeu;
    private Backlog backlog;

    public PlanningPoker(List<Joueur> listeJoueur, ModeDeJeu regle) //, Backlog backlog)
    {
        this.listeJoueurs = listeJoueur;
        this.modeDeJeu = regle;
        //this.backlog = backlog;
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