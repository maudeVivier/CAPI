/**
 * @file Fonctionnalite.java
 * @brief Définition de la classe Fonctionnalite pour représenter une fonctionnalité.
 */

import javax.swing.ListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @class Fonctionnalite
 * @brief Classe représentant une fonctionnalité dans le contexte du Planning Poker.
 */
public class Fonctionnalite {
    /** Description de la fonctionnalité. */
    private final String description;

    /** Difficulté associée à la fonctionnalité. */
    private String difficulte;

    /** Liste des fonctionnalités créées. */
    public static List<Fonctionnalite> listeFonctionnalites = new ArrayList<>();

    /**
     * @brief Constructeur de la classe Fonctionnalite.
     * @param des Description de la fonctionnalité.
     */
    public Fonctionnalite(String des) {
        this.description = des;
        this.difficulte = null;
    }

    /**
     * @brief Obtient la description de la fonctionnalité.
     * @return La description de la fonctionnalité.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @brief Obtient la difficulté associée à la fonctionnalité.
     * @return La difficulté associée à la fonctionnalité.
     */
    public String getDifficulte() {
        return difficulte;
    }

    /**
     * @brief Définit la difficulté associée à la fonctionnalité.
     * @param difficulte La difficulté à définir.
     */
    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    /**
     * @brief Ajoute une fonctionnalité à la liste.
     */
    public static void ajouterFonctionnalite(){
        String fonctionnalite = AffichageInfo.fieldFonctionnalite.getText();

        if(!fonctionnalite.isEmpty()){
            AffichageInfo.listeFonctionnalite.addElement(fonctionnalite);
            AffichageInfo.fieldFonctionnalite.setText("");
        }
    }

    /**
     * @brief Crée une liste d'objets Fonctionnalite à partir de la liste affichée dans l'interface.
     * @return Liste d'objets Fonctionnalite.
     */
    public static List<Fonctionnalite> creerListeFonctionnalites() {
        List<Fonctionnalite> listeFonc = new ArrayList<>();
        ListModel<String> fonctionnalite = AffichageInfo.listeFonctionnalite;

        for (int i = 0; i < fonctionnalite.getSize(); i++) {
            String description = fonctionnalite.getElementAt(i);
            listeFonc.add(new Fonctionnalite(String.valueOf(description)));
        }
        return listeFonc;
    }

    /**
     * @brief Affiche la liste des fonctionnalités.
     */
    public static void afficheListeFonctionnalites() {
        System.out.println("Liste des Fonctionnalites : ");
        for (Fonctionnalite listeFonctionnalite : listeFonctionnalites) {
            System.out.println(listeFonctionnalite.getDescription() + listeFonctionnalite.getDifficulte());
        }
    }
}
