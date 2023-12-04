package src.main.java;

import java.util.*;

public class Joueur {
    private final int monId;
    private final String monPseudo;
    private ArrayList<Carte> monCartes;
    private Carte monVoteCourant;

    public Joueur(int unId, String unPseudo)
    {
        monPseudo = unPseudo;
        monId = unId;
        //monCartes = ;
        //monVoteCourant = ;
    }
    public void voter(Carte carte) {
        // Logique de vote
    }
}