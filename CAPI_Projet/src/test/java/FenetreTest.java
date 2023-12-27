import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JFrame;


class FenetreTest {
    @Test
    void testFenetreCreation() {
        // Exécution de la méthode à tester
        Fenetre.main(new String[]{});

        // Récupération de l'instance de la fenêtre
        JFrame frame = Fenetre.frame;

        // Vérification du résultat
        assertNotNull(frame, "L'instance de la fenêtre ne devrait pas être nulle");
        assertFalse(frame.isVisible(), "La fenêtre devrait être visible");
        assertEquals("Planning Poker", frame.getTitle(), "Le titre de la fenêtre devrait être 'Planning Poker'");
    }
}
