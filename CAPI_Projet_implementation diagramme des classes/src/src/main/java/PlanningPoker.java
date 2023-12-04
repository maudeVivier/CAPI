package src.main.java;

import java.util.*;
public class PlanningPoker {
    private ArrayList<Joueur> monJoueurs;
    private ReglesPlanningPoker moRegles;
    private Backlog monBacklog;

    public PlanningPoker(ArrayList<Joueur> unListeJoueur, ReglesPlanningPoker unRegles, Backlog unBacklog)
    {
        monJoueurs = unListeJoueur;
        moRegles = unRegles;
        monBacklog = unBacklog;
    }
    public void initialiserPartie() {
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