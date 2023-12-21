import java.awt.Color;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.Timer;
import javax.swing.JOptionPane;

public class ReglesPlanningPoker {
    public static ModeDeJeu modeDeJeu;

    public static int moyenne;
    private static Map<String, Integer> resultatTour;
    private static Timer timerPartie;
    public static long debutPartieMillis;
    private static long pauseTimeMillis;
    public static long tempsPauseMillis;
    private static Timer timerInterro;
    private static int tempsPauseInterro = 0;
    private static final int tempsPauseTotal = 10; //En seconde


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
            Backlog.sauvegarderEnJSON();
            JOptionPane.showMessageDialog(null, "Partie sauvegarder dans un fichier JSON", "Information", JOptionPane.INFORMATION_MESSAGE);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Fermeture de la fenêtre
            Fenetre.frame.dispose();
        }
        return true;
    }

    public static void tempsPartie(){
        timerPartie = new Timer(1000, e -> { // A chaque seconde, on rentre dans cette partie
            debutPartieMillis++;
            miseAJourTimer();
            if (AffichageInfo.nbFonctionnalite == AffichageInfo.fonctionnaliteVote) {
                timerPartie.stop(); // On stoppe le timer quand la partie est finie
            }
        });

        // On démarre le timer
        timerPartie.start();
    }
    private static void miseAJourTimer() {
        long tempsEcouleTotal = System.currentTimeMillis() - debutPartieMillis;
        long secondesTotal = tempsEcouleTotal / 1000;

        long heures = secondesTotal / 3600;
        long minutes = (secondesTotal % 3600) / 60;
        long secondes = secondesTotal % 60;


        if(heures == 0) {
            if (minutes == 0) {
                AffichageInfo.labelTimer.setText("Temps écoulé : " + secondes + " sec");
            } else {
                AffichageInfo.labelTimer.setText("Temps écoulé : " + minutes + " min, " + secondes + " sec");
            }
        }else{
            AffichageInfo.labelTimer.setText("Temps écoulé : " + heures + " h, " + minutes + " min, " + secondes + " sec");
        }

    }
    public static void mettreEnPauseTimerPartie() {
        timerPartie.stop();
        tempsPauseMillis = System.currentTimeMillis() - debutPartieMillis;
        pauseTimeMillis = System.currentTimeMillis();
    }

    public static void reprendreTimerPartie() {
        debutPartieMillis = System.currentTimeMillis() - tempsPauseMillis;
        JOptionPane.showMessageDialog(null, "Le temps pour discuter est écoulé. Veuillez revoter.", "Information", JOptionPane.WARNING_MESSAGE);
        timerPartie.start();
    }

    public static void partieEnPauseInterro(){
        timerInterro = new Timer(1000, e -> {
            tempsPauseInterro++;
            miseAJourTimerInterro();
            if (tempsPauseInterro >= tempsPauseTotal) {
                timerInterro.stop();
                tempsPauseInterro = 0;
                reprendreTimerPartie();
                AffichageInfo.labelTimer.setForeground(Color.WHITE);
            }
        });

        timerInterro.start();

    }

    private static void miseAJourTimerInterro() {
        long tempsEcouleTotal = System.currentTimeMillis() - pauseTimeMillis;
        long secondesTotal = tempsEcouleTotal / 1000;

        long heures = secondesTotal / 3600;
        long minutes = (secondesTotal % 3600) / 60;
        long secondes = secondesTotal % 60;

        long heuresTempsTotal = tempsPauseTotal / 3600;
        long minutesTempsTotal = (tempsPauseTotal % 3600) / 60;
        long secondesTempsTotal = tempsPauseTotal % 60;

        AffichageInfo.labelTimer.setForeground(Color.RED);
        String tempsPause;

        if(heuresTempsTotal == 0) {
            if (minutesTempsTotal == 0) {
                tempsPause = "Temps de pause (" + secondesTempsTotal + " sec) : ";
                AffichageInfo.labelTimer.setText(tempsPause + secondes + " sec");
            } else {
                tempsPause = "Temps de pause (" + minutesTempsTotal + " min, " + secondesTempsTotal + " sec) : ";
                AffichageInfo.labelTimer.setText(tempsPause + minutes + " min, "  + secondes + " sec");
            }
        }else{
            tempsPause = "Temps de pause (" + heuresTempsTotal + " h, " + minutesTempsTotal + " min, " + secondesTempsTotal + " sec) : ";
            AffichageInfo.labelTimer.setText(tempsPause + heures + " h, " + minutes + " min, "  + secondes + " sec");
        }
    }
}