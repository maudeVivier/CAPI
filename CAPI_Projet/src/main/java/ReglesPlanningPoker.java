import java.util.*;
import java.util.stream.Collectors;

public class ReglesPlanningPoker {
    public static ModeDeJeu monModeDeJeu;
    private static int moyenne;
    private static Map<String, Integer> resultatTour;

    /*public ReglesPlanningPoker(ModeDeJeu unModeDeJeu) {
        this.monModeDeJeu = unModeDeJeu;
    }*/

    public static boolean appliquerRegles(ModeDeJeu modeDeJeu) {
        boolean res = false;
        if(modeDeJeu == ModeDeJeu.UNANIMITE || (modeDeJeu == ModeDeJeu.MOYENNE && AffichageInfo.tour==1)){

            System.out.println("Regle d'unanimité");
            res = resultatUnanimite();
            System.out.println(res);

        } else if (modeDeJeu == ModeDeJeu.MOYENNE) {

            moyenne = AffichageInfo.nbJoueur % 2;

            System.out.println("moyenne : " + moyenne);
            res = resultatMoyenne();
            System.out.println(res);
        }
        return res;
    }

    private static Map<String, Integer> compterNombreOccurence(List<String> listeCarte){
        // Utilisation d'une map pour compter les occurrences de chaque élément
        Map<String, Integer> occurrences = new HashMap<>();

        // Parcours de la liste pour compter les occurrences
        for (String element : listeCarte) {
            occurrences.put(element, occurrences.getOrDefault(element, 0) + 1);
        }


        // Tri de la map en fonction des occurrences (ordre décroissant)
        Map<String, Integer> occurrencesTriees = occurrences.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        // Affichage des occurrences triées
        for (Map.Entry<String, Integer> entry : occurrencesTriees.entrySet()) {
            System.out.println("Élément : " + entry.getKey() + ", Occurrences : " + entry.getValue());
        }

        return occurrencesTriees;
    }

    private static boolean resultatUnanimite(){
        resultatTour = compterNombreOccurence(AffichageInfo.cartesVotees);

        // Affichage des occurrences
        for (Map.Entry<String, Integer> entry : resultatTour.entrySet()) {
            System.out.println("-------------- Élément : " + entry.getKey() + ", Occurrences : " + entry.getValue());
            if(entry.getValue() == AffichageInfo.nbJoueur){
                System.out.println("------------------------------------------------- Élément : " + entry.getKey() + ", Occurrences : " + entry.getValue());
                return true;
            }
        }
        return false;
    }

    private static boolean resultatMoyenne(){
        resultatTour = compterNombreOccurence(AffichageInfo.cartesVotees);

        // Affichage des occurrences
        for (Map.Entry<String, Integer> entry : resultatTour.entrySet()) {
            System.out.println("-------------- Élément : " + entry.getKey() + ", Occurrences : " + entry.getValue());
            if(entry.getValue() >= moyenne){
                System.out.println("------------------------------------------------- Élément : " + entry.getKey() + ", Occurrences : " + entry.getValue());
                return true;
            }
        }
        return false;
    }
}