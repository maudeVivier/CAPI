import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Fonctionnalite {
    private final String description;
    private int difficulte;
    private boolean validee;

    public static List<Fonctionnalite> listeFonctionnalites = new ArrayList<>();

    public Fonctionnalite(String des) {
        this.description = des;
        this.difficulte = -1;
        this.validee = false;
    }

    public String getDescription() {
        return description;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public boolean getValidee() {
        return validee;
    }

    public void setValidee(boolean validee) {
        this.validee = validee;
    }

    public static void ajouterFonctionnalite(){
        String fonctionnalite = AffichageInfo.fieldFonctionnalite.getText();

        if(!fonctionnalite.isEmpty()){
            AffichageInfo.listeFonctionnalite.addElement(fonctionnalite);
            AffichageInfo.fieldFonctionnalite.setText("");
        }
    }

    public static List<Fonctionnalite> creerListeFonctionnalites() {
        List<Fonctionnalite> listeFonc = new ArrayList<>();
        ListModel<String> fonctionnalite = AffichageInfo.listeFonctionnalite;

        for (int i = 0; i < fonctionnalite.getSize(); i++) {
            String description = fonctionnalite.getElementAt(i);
            listeFonc.add(new Fonctionnalite(String.valueOf(description)));
        }
        return listeFonc;
    }

    public static void afficheListeFonctionnalites() {
        System.out.println("Liste des Fonctionnalites : ");
        for (Fonctionnalite listeFonctionnalite : listeFonctionnalites) {
            System.out.println(listeFonctionnalite.getDescription() + listeFonctionnalite.getDifficulte() + listeFonctionnalite.getValidee());
        }
    }
}
