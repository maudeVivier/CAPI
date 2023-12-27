import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReglesPlanningPokerTest {
    @Test
    void testAppliquerReglesModeUnanimite() {
        // Configuration du test
        AffichageInfo.tour = 1;
        AffichageInfo.nbJoueur = 5;
        AffichageInfo.cartesVotees.add("3");
        AffichageInfo.cartesVotees.add("3");
        AffichageInfo.cartesVotees.add("5");
        AffichageInfo.cartesVotees.add("8");
        AffichageInfo.cartesVotees.add("13");

        // Exécution de la méthode à tester
        String resultat = ReglesPlanningPoker.appliquerRegles(ModeDeJeu.UNANIMITE);

        // Vérification du résultat
        assertEquals("-1", resultat);
    }

    @Test
    void testAppliquerReglesModeMoyenne() {
        // Configuration du test
        AffichageInfo.tour = 2;
        AffichageInfo.nbJoueur = 6;
        AffichageInfo.cartesVotees.add("5");
        AffichageInfo.cartesVotees.add("8");
        AffichageInfo.cartesVotees.add("13");
        AffichageInfo.cartesVotees.add("13");
        AffichageInfo.cartesVotees.add("21");
        AffichageInfo.cartesVotees.add("34");

        // Exécution de la méthode à tester
        String resultat = ReglesPlanningPoker.appliquerRegles(ModeDeJeu.MOYENNE);

        // Vérification du résultat
        assertEquals("13", resultat);

        // Nettoyage après le test
    }

    @Test
    void testAppliquerReglesModeMoyennePremierTour() {
        // Configuration du test
        AffichageInfo.tour = 1;
        AffichageInfo.nbJoueur = 4;
        AffichageInfo.cartesVotees.add("5");
        AffichageInfo.cartesVotees.add("8");
        AffichageInfo.cartesVotees.add("13");
        AffichageInfo.cartesVotees.add("21");
        // Exécution de la méthode à tester
        String resultat = ReglesPlanningPoker.appliquerRegles(ModeDeJeu.MOYENNE);
        // Vérification du résultat
        assertEquals("-1", resultat);
    }
}
