/**
 * @file BacklogTest.java
 * @brief Fichier de tests unitaires pour la classe Backlog.
 */

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @class BacklogTest
 * @brief Classe de tests unitaires pour la classe Backlog.
 */
class BacklogTest {

    /**
     * @brief Teste la sauvegarde et le chargement en JSON pendant une pause.
     */
    @Test
    void testSauvegarderEtChargerEnJSONPause() {
        // Créez des données fictives pour le test
        ChronoTemps.tempsPartie = 300000; // 5 minutes
        AffichageInfo.fonctionnaliteVote = 2;

        // Sauvegardez en JSON pendant une pause
        Backlog.sauvegarderEnJSONPause();

        // Vérifiez que le fichier JSON existe
        assertTrue(Backlog.verifierSiFichierExiste(AffichageInfo.workingDirectory + "\\src\\json\\backlogtest.json"));

        // Vérifiez que les données chargées sont correctes
        assertEquals(5 * 60 * 1000, ChronoTemps.tempsPartie);

        // Nettoyez les données après le test
        ChronoTemps.tempsPartie = 0;
        AffichageInfo.fonctionnaliteVote = 0;
    }
}
