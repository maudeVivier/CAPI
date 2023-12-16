import javax.swing.*;
import java.io.IOException;
import java.util.*;
public class PlanningPoker {
    public static PlanningPoker planningPoker;
    public List<Joueur> listeJoueurs;
    public final ModeDeJeu modeDeJeu;

    public PlanningPoker(List<Joueur> listeJoueur, ModeDeJeu regle) {
        this.listeJoueurs = listeJoueur;
        this.modeDeJeu = regle;
    }

    public void validerBacklog() {
        // Logique de validation du backlog
    }

    public void enregistrerResultats() {
        // Logique d'enregistrement des résultats
    }

    public static void partieFinie(){
        JOptionPane.showMessageDialog(null, "<html>Toutes les fonctionnalités ont été traîtées" +
                "<br"+
                "Sauvegardé dans un fichier JSON</html>"
                , "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void chargerPartie() throws IOException {
        Backlog.chargerDepuisJSON();
        planningPoker = new PlanningPoker(Joueur.listeJoueurs, ReglesPlanningPoker.modeDeJeu);
    }
}