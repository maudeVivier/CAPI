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
        Backlog.sauvegarderEnJSON();
        JOptionPane.showMessageDialog(null, "<html>Toutes les fonctionnalités ont été traîtées" +
                "<br><br>"+
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

    public static void chargerPartie() throws IOException {
        Backlog.chargerDepuisJSON();
        planningPoker = new PlanningPoker(Joueur.listeJoueurs, ReglesPlanningPoker.modeDeJeu);
    }
}