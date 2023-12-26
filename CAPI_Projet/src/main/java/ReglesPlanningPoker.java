/**
 * @file ReglesPlanningPoker.java
 * @brief Définition de la classe ReglesPlanningPoker.
 */

import javax.swing.JOptionPane;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @class ReglesPlanningPoker
 * @brief Applique les règles du planning poker en fonction du mode de jeu.
 */
public class ReglesPlanningPoker {
    /**
     * Mode de jeu utilisé.
     */
    public static ModeDeJeu modeDeJeu;

    /**
     * Moyenne calculée pendant le jeu en mode "MOYENNE".
     */
    public static int moyenne;

    /**
     * Résultat du tour en cours, cartes votées avec leurs occurrences.
     */
    private static Map<String, Integer> resultatTour;

    /**
     * Applique les règles du planning poker en fonction du mode de jeu.
     *
     * @param modeDeJeu Mode de jeu à appliquer.
     * @return Résultat du tour en cours.
     */
    public static String appliquerRegles(ModeDeJeu modeDeJeu) {
        String res = null;
        if(modeDeJeu == ModeDeJeu.UNANIMITE || (modeDeJeu == ModeDeJeu.MOYENNE && AffichageInfo.tour==1)){
            res = resultatUnanimite();
        } else if (modeDeJeu == ModeDeJeu.MOYENNE) {
            moyenne = AffichageInfo.nbJoueur % 2;
            res = resultatMoyenne();
        }
        return res;
    }

    /**
     * Compte le nombre d'occurrences de chaque carte dans la liste.
     *
     * @param listeCarte Liste des cartes votées.
     * @return Map contenant les cartes et leur nombre d'occurrences triées par ordre décroissant.
     */
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

    /**
     * Applique les règles du mode "UNANIMITE".
     *
     * @return Résultat du tour en cours en mode "UNANIMITE".
     */
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

    /**
     * Applique les règles du mode "MOYENNE".
     *
     * @return Résultat du tour en cours en mode "MOYENNE".
     */
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

    /**
     * Met en pause la partie et sauvegarde l'état du jeu en JSON si la carte "cafe" est choisie.
     *
     * @param entry Entry représentant la carte choisie et son nombre d'occurrences.
     * @return true si la partie est mise en pause, sinon false.
     */
    private static boolean partieEnPauseCafe(Map.Entry<String, Integer> entry){
        if(entry.getKey().equals("cafe")){
            ChronoTemps.mettreEnPauseTimerPartie();
            Backlog.sauvegarderEnJSONPause();
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