package src.main.java;

import java.util.ArrayList;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
public class Backlog {
    // Liste de fonctionnalité
    private ArrayList<Fonctionnalite> monListeFonctionnalites;
    public Backlog() {

        this.monListeFonctionnalites = new ArrayList<>();
    }
    public void ajouterFonctionnalite(Fonctionnalite fonctionnalite) {

        monListeFonctionnalites.add(fonctionnalite);
    }
    /*
     * La méthode sauvegarderEnJSON utilise un bloc try-catch
     * pour intercepter toute exception liée à l'écriture du fichier.
     * Si une IOException se produit lors de l'écriture du fichier,
     * elle sera interceptée et traitée dans le bloc catch.
     * */
    /*public void sauvegarderEnJSON(String chemin) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(new File(chemin), this);
            System.out.println("Backlog sauvegardé en JSON avec succès.");
        } catch (IOException e) {
            // Gérer les exceptions liées à l'écriture du fichier
            e.printStackTrace();
        }

    }*/
    /*
     * La méthode chargerDepuisJSON utilise un bloc try-catch
     * pour intercepter différentes exceptions qui pourraient survenir
     * lors de la lecture et de la désérialisation du fichier JSON.
     * Les exceptions spécifiques liées à Jackson
     * sont ajoutées dans les blocs catch correspondants.
     * */
    /*public static Backlog chargerDepuisJSON(String chemin) {
        ObjectMapper objectMapper = new ObjectMapper();
        Backlog backlog = null;

        try {
            backlog = objectMapper.readValue(new File(chemin), Backlog.class);
            System.out.println("Backlog chargé depuis le fichier JSON avec succès.");
        } catch (IOException e) {
            // Gérer les exceptions liées à la lecture ou à la désérialisation du fichier JSON
            e.printStackTrace();
        }

        return backlog;
    }*/
}
