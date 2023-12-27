/**
 * @file FenetreTest.java
 * @brief Fichier de tests unitaires pour la classe Fenetre.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JFrame;

/**
 * @class FenetreTest
 * @brief Classe de tests unitaires pour la classe Fenetre.
 */
class FenetreTest {

    /**
     * @brief Teste la création de la fenêtre.
     */
    @Test
    void testFenetreCreation() {
        // Exécution de la méthode à tester
        Fenetre.main(new String[]{});

        // Récupération de l'instance de la fenêtre
        JFrame frame = Fenetre.frame;

        // Vérification du résultat
        assertNotNull(frame, "L'instance de la fenêtre ne devrait pas être nulle");
        assertFalse(frame.isVisible(), "La fenêtre devrait être invisible");
        assertEquals("Planning Poker", frame.getTitle(), "Le titre de la fenêtre devrait être 'Planning Poker'");
    }
}
