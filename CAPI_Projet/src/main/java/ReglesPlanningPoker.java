import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReglesPlanningPoker {
    public static ModeDeJeu modeDeJeu;

    public static int moyenne;
    private static Map<String, Integer> resultatTour;


    public static String appliquerRegles(ModeDeJeu modeDeJeu) {
        String res = null;
        if(modeDeJeu == ModeDeJeu.UNANIMITE || (modeDeJeu == ModeDeJeu.MOYENNE && AffichageInfo.tour==1)){
            res = resultatUnanimite();
        } else if (modeDeJeu == ModeDeJeu.MOYENNE) {
            moyenne = AffichageInfo.nbJoueur % 2;
            res = resultatMoyenne();
        }
        System.out.println(res);
        return res;
    }

    private static Map<String, Integer> compterNombreOccurence(List<String> listeCarte){
        // Utilisation d'une map pour compter les occurrences de chaque élément
        Map<String, Integer> occurrences = new HashMap<>();

        // Parcours de la liste pour compter les occurrences
        for (String element : listeCarte) {
            occurrences.put(element, occurrences.getOrDefault(element, 0) + 1);
        }

        // Tri de la map par ordre decroissant en fonction des occurrences
        // pour avoir la bonne reponse
        Map<String, Integer> occurrencesTriees = occurrences.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return occurrencesTriees;
    }

    private static String resultatUnanimite(){
        resultatTour = compterNombreOccurence(AffichageInfo.cartesVotees);

        // Affichage des occurrences
        for (Map.Entry<String, Integer> entry : resultatTour.entrySet()) {
            if(entry.getValue() == AffichageInfo.nbJoueur){
                if(partieEnPauseCafe(entry)){
                    return entry.getKey();
                }
            }
        }
        return "-1";
    }

    private static String resultatMoyenne(){
        resultatTour = compterNombreOccurence(AffichageInfo.cartesVotees);

        for (Map.Entry<String, Integer> entry : resultatTour.entrySet()) {
            if(entry.getValue() >= moyenne){
                if(partieEnPauseCafe(entry)) {
                    return entry.getKey();
                }
            }
        }
        return "-1";
    }

    private static boolean partieEnPauseCafe(Map.Entry<String, Integer> entry){
        if(entry.getKey().equals("cafe")){
            ChronoTemps.mettreEnPauseTimerPartie();
            Backlog.sauvegarderEnJSON();
            JOptionPane.showMessageDialog(null, "Partie sauvegarder dans un fichier JSON", "Information", JOptionPane.INFORMATION_MESSAGE);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Fermeture de la fenêtre
            Fenetre.frame.dispose();
        }
        return true;
    }
}