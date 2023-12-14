import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Fonctionnalite {
    private static String description;
    private static int difficulte;
    private static boolean validee;

    // Liste de fonctionnalité
    public static List<Fonctionnalite> listeFonctionnalites;

    public Fonctionnalite(String des){
        description = des;
        difficulte = -1;
        validee = false;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Fonctionnalite.description = description;
    }

    public static int getDifficulte() {
        return difficulte;
    }

    public static void setDifficulte(int difficulte) {
        Fonctionnalite.difficulte = difficulte;
    }

    public static boolean isValidee() {
        return validee;
    }

    public static void setValidee(boolean validee) {
        Fonctionnalite.validee = validee;
    }
    public static List<Fonctionnalite> ajouterFonctionnalites() {
        List<Fonctionnalite> listeFonc = new ArrayList<>();
        ListModel<String> tache = AffichageInfo.listeTache;
        System.out.println("Liste des taches dans BACKLOG: ");
        for (int i = 0; i < tache.getSize(); i++) {
            String description = tache.getElementAt(i);
            System.out.println(description);
            listeFonc.add(new Fonctionnalite(description));
        }
        return listeFonc;
    }

    public static void afficheListeFonctionnalite(List<Fonctionnalite> listeFonctionnalites){
        // Parcourir et afficher la liste des joueurs
        for (Fonctionnalite fonctionnalite : listeFonctionnalites) {
            System.out.println("Description: " + getDescription());
        }
    }
}