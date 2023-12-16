import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Fonctionnalite {
    private String description;
    private int difficulte;
    private boolean validee;

    public static List<Fonctionnalite> listeFonctionnalites;

    public Fonctionnalite(String des) {
        this.description = des;
        this.difficulte = -1;
        this.validee = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public boolean isValidee() {
        return validee;
    }

    public void setValidee(boolean validee) {
        this.validee = validee;
    }

    public static List<Fonctionnalite> ajouterFonctionnalites() {
        List<Fonctionnalite> listeFonc = new ArrayList<>();
        ListModel<String> tache = AffichageInfo.listeTache;
        System.out.println("Liste des taches dans BACKLOG: ");
        for (int i = 0; i < tache.getSize(); i++) {
            String description = tache.getElementAt(i);
            System.out.println(description);
            listeFonc.add(new Fonctionnalite(String.valueOf(description)));
        }
        return listeFonc;
    }

    public static void ajouterFonctionnalite(){
        String tache = AffichageInfo.fieldTache.getText();
        System.out.println("Tache : " + tache);
        if(!tache.isEmpty()){
            AffichageInfo.listeTache.addElement(tache);
            AffichageInfo.fieldTache.setText("");
        }
    }
    public static void afficherListe() {
        ListModel<String> tache = AffichageInfo.listeTache;
        System.out.println("Liste des taches : ");
        for (int i = 0; i < tache.getSize(); i++) {
            System.out.println(tache.getElementAt(i));
        }
    }
    public static void afficheListeFonctionnalite(List<Fonctionnalite> listeFonctionnalites) {
        for (int i = 0; i < listeFonctionnalites.size(); i++) {
            System.out.println("Description: " + listeFonctionnalites.get(i).getDescription());
        }
    }
}
