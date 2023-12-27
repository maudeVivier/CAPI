import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class ChronoTempsTest {

    @Test
    void testTempsPartie() {
        // Créez une instance de ChronoTemps
        ChronoTemps chronoTemps = new ChronoTemps();

        // Utilisez un mock pour la JLabel d'affichage du temps
        JLabel labelTimer = new JLabel();
        AffichageInfo.labelTimer = labelTimer;

        // Démarrez le timer de partie
        chronoTemps.tempsPartie();

        // Attendez quelques secondes pour permettre au timer de s'exécuter
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Vérifiez que le temps affiché a été mis à jour
        assertNotEquals("Temps écoulé : 0 sec", labelTimer.getText());

        // Mettez en pause le timer de partie
        chronoTemps.mettreEnPauseTimerPartie();

        // Obtenez le temps actuel
        int tempsAvantPause = ChronoTemps.tempsPartie;

        // Attendez quelques secondes supplémentaires
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Vérifiez que le temps n'a pas changé après la pause
        assertEquals(tempsAvantPause, ChronoTemps.tempsPartie);
    }
}
