import javax.swing.Timer;
import javax.swing.JOptionPane;

import java.awt.Color;

public class ChronoTemps {
    private static Timer timerPartie;
    public static int tempsPartie = 0;
    private static Timer timerInterro;
    private static int tempsPauseInterro = 0;
    private static final int tempsPauseTotal = 10; //En seconde

    public static void tempsPartie(){
        timerPartie = new Timer(1000, e -> { // A chaque seconde, on rentre dans cette partie
            tempsPartie+=1000;
            miseAJourTimerPartie();
            if (AffichageInfo.nbFonctionnalite == AffichageInfo.fonctionnaliteVote) {
                timerPartie.stop(); // On stoppe le timer quand la partie est finie
            }
        });

        // On démarre le timer
        timerPartie.start();
    }


    private static void miseAJourTimerPartie() {
        int tempsEcouleTotal = tempsPartie;
        int secondesTotal = tempsEcouleTotal / 1000;

        int heures = secondesTotal / 3600;
        int minutes = (secondesTotal % 3600) / 60;
        int secondes = secondesTotal % 60;

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
    }

    public static void reprendreTimerPartieInterro() {
        JOptionPane.showMessageDialog(null, "Le temps pour discuter est écoulé. Veuillez revoter.", "Information", JOptionPane.WARNING_MESSAGE);
        timerPartie.start();
    }

    public static void partieEnPauseInterro(){
        timerInterro = new Timer(1000, e -> {
            tempsPauseInterro+=1000;
            miseAJourTimerInterro();
            if (tempsPauseInterro >= tempsPauseTotal*1000) {
                timerInterro.stop();
                tempsPauseInterro = 0;
                reprendreTimerPartieInterro();
                AffichageInfo.labelTimer.setForeground(Color.WHITE);
            }
        });
        timerInterro.start();
    }

    private static void miseAJourTimerInterro() {
        int secondesTotal = tempsPauseInterro / 1000;

        int heures = secondesTotal / 3600;
        int minutes = (secondesTotal % 3600) / 60;
        int secondes = secondesTotal % 60;

        int heuresTempsTotal = tempsPauseTotal / 3600;
        int minutesTempsTotal = (tempsPauseTotal % 3600) / 60;
        int secondesTempsTotal = tempsPauseTotal % 60;

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
